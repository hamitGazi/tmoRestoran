package hamit.demir.service.siparis;

import hamit.demir.model.dto.siparis.SiparisAllResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.entity.*;
import hamit.demir.repository.MasaRepository;
import hamit.demir.repository.menuFiyat.MenuFiyatRepository;
import hamit.demir.repository.menuItem.MenuItemRepository;
import hamit.demir.repository.odeme.OdemeRepository;
import hamit.demir.repository.personel.PersonelRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.repository.siparisKalemi.SiparisKalemRepository;
import hamit.demir.repository.stokKalem.StokKalemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class SiparisServiceImpl implements SiparisService {
    private final SiparisRepository siparisRepository;
    private final MasaRepository masaRepository;
    private final SiparisKalemRepository siparisKalemRepository;
    private final PersonelRepository personelRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuFiyatRepository menuFiyatRepository;
    private final OdemeRepository odemeRepository;

    private final StokKalemRepository stokKalemRepository;

    @Override
    public List<SiparisAllResponse> getAllSiparisler() {
        return siparisRepository.getAllSiparisler();
    }

    @Override
    public SiparisAllResponse getSiparisById(Long id) {
        return siparisRepository.fetchSiparisById(id);
    }

    @Override
    public Long updateSiparis(SiparisUpdateRequest request) {
        SiparisEntity entity = siparisRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Sipariş bulunamadı! Lütfen tekrar deneyiniz..",
                                HttpStatus.NOT_FOUND.toString())));
        entity.setMasa(request.masa() != null ? masaRepository.getReferenceById(request.masa()) : null);
        entity.setPersonel(request.personel() != null ? personelRepository.getReferenceById(request.personel()) : null);
        entity.setMusteriAd(request.musteriAd());
        SiparisDurumu yeniDurum = request.durum() != null ? request.durum() : SiparisDurumu.HAZIRLANIYOR;
        entity.setSiparisDurumu(yeniDurum);
        entity.setSiparisNot(request.siparisNot());
        entity.setGuncelleZamani(LocalDateTime.now());
        SiparisEntity updatedEntity = siparisRepository.save(entity);
        OdemeEntity odemeEntity = odemeRepository.fethOdemeBYSiparisId(updatedEntity.getId());

        if (odemeEntity != null) {
            // Sipariş iptal edildiyse ödeme durumu da iptal edilmeli
            if (yeniDurum == SiparisDurumu.IPTAL_EDILDI && odemeEntity.getOdemeDurum() != OdemeDurumu.IPTAL_EDILDI) {
                odemeEntity.setOdemeDurum(OdemeDurumu.IPTAL_EDILDI);
                odemeRepository.save(odemeEntity);
            }
        } else {

            saveOrCreateOdeme(updatedEntity);
        }
        return updatedEntity.getId();
    }

    private void saveOrCreateOdeme(SiparisEntity siparis) {
        OdemeEntity odemeEntity = new OdemeEntity();
        odemeEntity.setSiparis(siparis);
        odemeEntity.setOdemeZamani(LocalDateTime.now());
        odemeEntity.setYontemi(OdemeYontem.SECILMEDI);
        odemeEntity.setOdemeDurum(OdemeDurumu.BEKLIYOR);
        odemeEntity.setToplamTutar(siparis.getToplamTutar());
        odemeRepository.save(odemeEntity);
    }

    @Override
    public String deleteSiparis(Long id) {
        SiparisEntity entity = siparisRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Siparis Bulunamadı! Lütfen tekrar deneyiniz..",
                                HttpStatus.NOT_FOUND.toString())));
        siparisRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

    @Override
    @Transactional
    public Long saveSiparis(SiparisSaveRequest request) {
        Logger logger = LoggerFactory.getLogger(SiparisService.class);
        LocalDateTime now = LocalDateTime.now();
        SiparisEntity siparis = new SiparisEntity();
        siparis.setMasa(masaRepository.getReferenceById(request.masa()));
        siparis.setSiparisDurumu(SiparisDurumu.HAZIRLANIYOR);
        siparis.setMusteriAd(request.musteriAd());
        if (request.personel() != null) {
            siparis.setPersonel(personelRepository.getReferenceById(request.personel()));
        } else {
            siparis.setPersonel(null);
        }
        siparis.setSiparisNot(request.siparisNot());
        siparis.setOlusturmaZamani(now);
        siparisRepository.save(siparis);

        List<Long> itemIds = request.menuItems().stream()
                .map(SiparisKalemiSaveRequest::menuItem)
                .distinct()
                .toList();
        List<MenuFiyatEntity> fiyatlar = menuFiyatRepository.fetMenuFiyatInIds(itemIds, now);
        Map<Long, MenuFiyatEntity> fiyatMap = fiyatlar.stream()
                .collect(Collectors.toMap(
                        f -> f.getMenuItem().getId(),
                        f -> f,
                        (f1, f2) -> {
                            if (f1.getGuncelleTarih() == null) return f2;
                            if (f2.getGuncelleTarih() == null) return f1;
                            return f1.getGuncelleTarih().isAfter(f2.getGuncelleTarih()) ? f1 : f2;
                        }
                ));

        // Tüm reçeteleri toplu çek
        List<MenuItemReceteEntity> allReceteler = menuItemRepository.findByMenuItemIds((itemIds));
        Map<Long, List<MenuItemReceteEntity>> receteMap = allReceteler.stream()
                .collect(Collectors.groupingBy(r -> r.getMenuUrun().getId()));

        BigDecimal toplamTutar = BigDecimal.ZERO;
        List<SiparisKalemiEntity> kalemler = new ArrayList<>();

        // Stok kontrolleri
        for (SiparisKalemiSaveRequest item : request.menuItems()) {
            MenuFiyatEntity fiyatEntity = fiyatMap.get(item.menuItem());
            if (fiyatEntity == null) {
                throw new BaseException(GenericResponse.error(
                        "Fiyat bulunamadı: Menu Item ID: " + item.menuItem(),
                        HttpStatus.BAD_REQUEST.toString()));
            }
            MenuItemEntity menuItem = menuItemRepository.getReferenceById(item.menuItem());
            List<MenuItemReceteEntity> receteler = receteMap.getOrDefault(menuItem.getId(), List.of());
            for (MenuItemReceteEntity recete : receteler) {
                controlStokForRecete(recete, item.adet());
            }

            // Sipariş kalemi oluştur
            BigDecimal fiyat = fiyatEntity.getFiyat();
            SiparisKalemiEntity kalem = new SiparisKalemiEntity();
            kalem.setMenuItem(menuItem);
            kalem.setAdet(item.adet());
            kalem.setBirimFiyat(fiyat);
            kalem.setToplamFiyat(fiyat.multiply(BigDecimal.valueOf(item.adet())));
            kalem.setKalemNot(item.kalemNot());
            kalem.setEkOzellikler(item.ekOzellikler());
            kalem.setSiparis(siparis);
            toplamTutar = toplamTutar.add(kalem.getToplamFiyat());
            kalemler.add(kalem);
        }

        siparisKalemRepository.saveAll(kalemler);
        siparis.setToplamTutar(toplamTutar);
        siparisRepository.save(siparis);
        saveOdeme(siparis, now);
        return siparis.getId();
    }

    private void saveOdeme(SiparisEntity siparis, LocalDateTime odemeZamani) {
        OdemeEntity odemeEntity = new OdemeEntity();
        odemeEntity.setSiparis(siparis);
        odemeEntity.setOdemeZamani(odemeZamani);
        odemeEntity.setYontemi(OdemeYontem.SECILMEDI);
        odemeEntity.setOdemeDurum(OdemeDurumu.BEKLIYOR);
        odemeEntity.setToplamTutar(siparis.getToplamTutar());
        odemeRepository.save(odemeEntity);
    }

    private void controlStokForRecete(MenuItemReceteEntity recete, int adet) {
        Logger logger = LoggerFactory.getLogger(SiparisService.class);
        StokKalemiEntity stok = stokKalemRepository.findById(recete.getStokKalemi().getId())
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Stok bulunamadı: " + recete.getStokKalemi().getAd(),
                        HttpStatus.NOT_FOUND.toString())));

        BigDecimal gerekliMiktar = recete.getMiktar().multiply(BigDecimal.valueOf(adet));

        // Stok tükenmiş mi kontrol
        if (stok.getMiktar().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BaseException(GenericResponse.error(
                    "Stok tükenmiş: " + stok.getAd(),
                    HttpStatus.BAD_REQUEST.toString()));
        }

        // Sipariş miktarı stoktan fazla ise sipariş alınamaz
        if (stok.getMiktar().compareTo(gerekliMiktar) < 0) {
            throw new BaseException(GenericResponse.error(
                    "Yetersiz stok: " + stok.getAd(),
                    HttpStatus.BAD_REQUEST.toString()));
        }

        // Kritik stok kontrolü (uyarı ver, siparişi al)
        if (stok.getKiritikMiktar() != null && stok.getMiktar().compareTo(stok.getKiritikMiktar()) <= 0) {
            logger.warn("Uyarı: Stok kritik seviyede: {}", stok.getAd());
        }
    }
    @Transactional
    @Override
    public void siparisOdmeAndUpdateStok(Long odemeId) {
        OdemeEntity odeme = getValidOdeme(odemeId);
        List<SiparisKalemiEntity> kalemler = getSiparisKalemleri(odeme);
        kalemler.forEach(this::updateStockForKalem);
    }

    private OdemeEntity getValidOdeme(Long odemeId) {
        OdemeEntity odeme = odemeRepository.findById(odemeId)
                .orElseThrow(() -> new BaseException(GenericResponse.error("Ödeme bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        if (odeme.getOdemeDurum() != OdemeDurumu.BASARILI) {
            throw new BaseException(GenericResponse.error("Ödeme başarılı değil!", HttpStatus.BAD_REQUEST.toString()));
        }
        return odeme;
    }
    private List<SiparisKalemiEntity> getSiparisKalemleri(OdemeEntity odeme) {
        return siparisKalemRepository.findBySiparisId(odeme.getSiparis().getId());
    }

    private void updateStockForKalem(SiparisKalemiEntity kalem) {
        menuItemRepository.findByMenuItemId(kalem.getMenuItem().getId())
                .forEach(recete -> updateStockForRecete(recete, kalem.getAdet()));
    }

    private void updateStockForRecete(MenuItemReceteEntity recete, int adet) {
        StokKalemiEntity stok = stokKalemRepository.findById(recete.getStokKalemi().getId())
                .orElseThrow(() -> new BaseException(GenericResponse.error("Stok bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        BigDecimal gerekliMiktar = recete.getMiktar().multiply(BigDecimal.valueOf(adet));
        if (stok.getMiktar().compareTo(gerekliMiktar) < 0) {
            System.out.println("Yetersiz stok: " + stok.getAd());
        }
        if (stok.getKiritikMiktar() != null && stok.getMiktar().compareTo(stok.getKiritikMiktar()) <= 0) {

            System.out.println("Uyarı: Stok kritik seviyede:" +stok.getAd()+
                    "Mevcut miktar:"+ stok.getMiktar());
        }
        stok.setMiktar(stok.getMiktar().subtract(gerekliMiktar));
        stok.setGuncelleTarih(LocalDateTime.now());
        stokKalemRepository.save(stok);
    }

}