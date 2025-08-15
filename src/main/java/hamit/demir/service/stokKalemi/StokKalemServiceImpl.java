package hamit.demir.service.stokKalemi;

import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.StokKalemi.StokKalemiSaveRequest;
import hamit.demir.model.dto.StokKalemi.StokKalemiUpdateRequest;
import hamit.demir.model.entity.IslemTipEnum;
import hamit.demir.model.entity.MenuItemReceteEntity;
import hamit.demir.model.entity.SiparisKalemiEntity;
import hamit.demir.model.entity.StokKalemiEntity;
import hamit.demir.repository.menuItemRecete.MenuItemReceteRepository;
import hamit.demir.repository.siparisKalemi.SiparisKalemRepository;
import hamit.demir.repository.stokHareket.StokHareketRepository;
import hamit.demir.repository.stokKalem.StokKalemRepository;
import hamit.demir.service.stokHareket.StokHareketService;
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
import java.util.List;
/*

@Service
@Transactional
@RequiredArgsConstructor
public class StokKalemServiceImpl implements StokKalemService {
    private final Logger logger = LoggerFactory.getLogger(StokKalemServiceImpl.class);
    private final StokKalemRepository stokKalemRepository;
    private final StokHareketService stokHareketService;

    @Override
    public List<StokKalemiResponse> getAllStokKalemler() {
        return stokKalemRepository.fetchAllStokKalemler();
    }

    @Override
    public StokKalemiResponse getStokKalemById(Long id) {
        return stokKalemRepository.fetchStokKalemById(id);
    }

    @Override
    public Long saveStokKalem(StokKalemiSaveRequest request) {
        // Validasyon
        if (request.miktar().compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException(
                    GenericResponse.error("Miktar negatif olamaz!", HttpStatus.BAD_REQUEST.toString()));
        }
        if (request.kiritikMiktar().compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException(
                    GenericResponse.error("Kritik miktar negatif olamaz!", HttpStatus.BAD_REQUEST.toString()));
        }

        // Stok kalemi oluştur
        StokKalemiEntity entity = new StokKalemiEntity();
        entity.setAd(request.ad());
        entity.setMiktar(request.miktar());
        entity.setKritikMiktar(request.kiritikMiktar());
        entity.setBirim(request.birim());
        entity.setAktif(request.aktif());
        entity.setOlusturmaTarih(LocalDateTime.now());

        // Kaydet ve hareket oluştur
        StokKalemiEntity savedEntity = stokKalemRepository.save(entity);
        stokHareketService.saveHareket(
                savedEntity.getId(),
                request.miktar(),
                IslemTipEnum.GIRIS,
                "Yeni stok kaydı: " + request.ad()
        );

        // Kritik miktar kontrolü
        if (savedEntity.getMiktar().compareTo(savedEntity.getKritikMiktar()) <= 0) {
            logger.warn("Kritik stok uyarısı: {} (Miktar: {}, Kritik: {})",
                    savedEntity.getAd(), savedEntity.getMiktar(), savedEntity.getKritikMiktar());
            // TODO: NotificationService ile uyarı gönder
        }

        return savedEntity.getId();
    }

    @Override
    public Long updateStokKalem(StokKalemiUpdateRequest request) {
        // Mevcut stok kalemini bul
        StokKalemiEntity entity = stokKalemRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Stok kalemi bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        // Validasyon
        if (request.miktar().compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException(
                    GenericResponse.error("Miktar negatif olamaz!", HttpStatus.BAD_REQUEST.toString()));
        }
        if (request.kritikMiktar().compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException(
                    GenericResponse.error("Kritik miktar negatif olamaz!", HttpStatus.BAD_REQUEST.toString()));
        }

        // Miktar farkını hesapla
        BigDecimal eskiMiktar = entity.getMiktar();
        BigDecimal yeniMiktar = request.miktar();
        BigDecimal fark = yeniMiktar.subtract(eskiMiktar);
        IslemTipEnum islemTipi = fark.compareTo(BigDecimal.ZERO) >= 0 ? IslemTipEnum.GIRIS : request.islemTip();

        // Güncelle
        entity.setAd(request.ad());
        entity.setMiktar(yeniMiktar);
        entity.setKritikMiktar(request.kritikMiktar());
        entity.setBirim(request.birim());
        entity.setAktif(request.aktif());
        entity.setGuncelleTarih(LocalDateTime.now());

        // Kaydet ve hareket oluştur
        StokKalemiEntity updatedEntity = stokKalemRepository.save(entity);

        if (fark.compareTo(BigDecimal.ZERO) != 0) {
            String aciklama = request.aciklama() != null ? request.aciklama() : islemTipi.getLabel() + ": " + updatedEntity.getAd();
            stokHareketService.updateHareket(updatedEntity.getId(), fark, islemTipi, aciklama);
        }
        // Kritik miktar kontrolü
        if (updatedEntity.getMiktar().compareTo(updatedEntity.getKritikMiktar()) <= 0) {
            logger.warn("Kritik stok uyarısı: {} (Miktar: {}, Kritik: {})",
                    updatedEntity.getAd(), updatedEntity.getMiktar(), updatedEntity.getKritikMiktar());
            // TODO: NotificationService ile uyarı gönder
        }

        return updatedEntity.getId();
    }

}
*/

@Service
@Transactional
@RequiredArgsConstructor
public class StokKalemServiceImpl implements StokKalemService {
    private final StokKalemRepository stokKalemRepository;
    private final StokHareketService stokHareketService;
    private final MenuItemReceteRepository menuItemReceteRepository;
    private final SiparisKalemRepository siparisKalemRepository;
    private final StokHareketRepository stokHareketRepository;
    private final Logger logger = LoggerFactory.getLogger(StokKalemServiceImpl.class);

    @Override
    public List<StokKalemiResponse> getAllStokKalemler() {
        return stokKalemRepository.fetchAllStokKalemler();
    }

    @Override
    public StokKalemiResponse getStokKalemById(Long id) {
        return stokKalemRepository.fetchStokKalemById(id);
    }

    @Override
    public Long saveStokKalem(StokKalemiSaveRequest request) {
        validateStockRequest(request.miktar(), request.kritikMiktar());
        StokKalemiEntity entity = new StokKalemiEntity();
        entity.setAd(request.ad());
        entity.setMiktar(request.miktar());
        entity.setKritikMiktar(request.kritikMiktar());
        entity.setBirim(request.birim());
        entity.setAktif(request.aktif());
        entity.setAciklama(request.aciklama());
        entity.setOlusturmaTarih(LocalDateTime.now());
        StokKalemiEntity savedEntity = stokKalemRepository.save(entity);
        stokHareketService.createHareket(
                savedEntity.getId(),
                request.miktar(),
                IslemTipEnum.GIRIS,
                "Yeni stok kaydı: " + request.ad()
        );
        checkCriticalStock(savedEntity);
        return savedEntity.getId();
    }

    @Override
    public Long updateStokKalem(StokKalemiUpdateRequest request) {
        StokKalemiEntity entity = stokKalemRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Stok kalemi bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        validateStockRequest(request.miktar(), request.kritikMiktar());
        BigDecimal eskiMiktar = entity.getMiktar();
        BigDecimal yeniMiktar = request.miktar();
        BigDecimal fark = yeniMiktar.subtract(eskiMiktar);
        IslemTipEnum islemTipi = fark.compareTo(BigDecimal.ZERO) >= 0 ? IslemTipEnum.GIRIS : request.islemTip();
        entity.setAd(request.ad());
        entity.setMiktar(yeniMiktar);
        entity.setKritikMiktar(request.kritikMiktar());
        entity.setBirim(request.birim());
        entity.setAktif(request.aktif());
        entity.setKritikMiktar(request.kritikMiktar());
        entity.setAciklama(request.aciklama());
        entity.setGuncelleTarih(LocalDateTime.now());
        StokKalemiEntity updatedEntity = stokKalemRepository.save(entity);
        if (fark.compareTo(BigDecimal.ZERO) != 0) {
            stokHareketService.createHareket(
                    updatedEntity.getId(),
                    fark,
                    islemTipi,
                    request.aciklama() != null ? request.aciklama() : islemTipi.getLabel() + ": " + updatedEntity.getAd()
            );
        }
        checkCriticalStock(updatedEntity);
        return updatedEntity.getId();
    }

    @Override
    public void checkStockAvailability(Long menuItemId, int adet) {
        List<MenuItemReceteEntity> receteler = menuItemReceteRepository.fetchRecetelerByMenuItemId(menuItemId);
        for (MenuItemReceteEntity recete : receteler) {
            StokKalemiEntity stok = stokKalemRepository.findById(recete.getStokKalemi().getId())
                    .orElseThrow(() -> new BaseException(
                            GenericResponse.error("Stok bulunamadı: " + recete.getStokKalemi().getAd(),
                                    HttpStatus.NOT_FOUND.toString())));
            BigDecimal gerekliMiktar = recete.getMiktar().multiply(BigDecimal.valueOf(adet));
            if (stok.getMiktar().compareTo(BigDecimal.ZERO) <= 0) {
                throw new BaseException(
                        GenericResponse.error("Stok tükenmiş: " + stok.getAd(),
                                HttpStatus.BAD_REQUEST.toString()));
            }
            if (stok.getMiktar().compareTo(gerekliMiktar) < 0) {
                throw new BaseException(
                        GenericResponse.error("Yetersiz stok: " + stok.getAd(),
                                HttpStatus.BAD_REQUEST.toString()));
            }
            checkCriticalStock(stok);
        }
    }

    @Override
    public void decreaseStockForOrder(Long siparisId) {
        List<SiparisKalemiEntity> kalemler = siparisKalemRepository.findBySiparisId(siparisId);
        for (SiparisKalemiEntity kalem : kalemler) {
            List<MenuItemReceteEntity> receteler = menuItemReceteRepository.fetchRecetelerByMenuItemId((kalem.getMenuItem().getId()));
            for (MenuItemReceteEntity recete : receteler) {
                StokKalemiEntity stok = stokKalemRepository.findById(recete.getStokKalemi().getId())
                        .orElseThrow(() -> new BaseException(
                                GenericResponse.error("Stok bulunamadı: " + recete.getStokKalemi().getAd(),
                                        HttpStatus.NOT_FOUND.toString())));
                BigDecimal gerekliMiktar = recete.getMiktar().multiply(BigDecimal.valueOf(kalem.getAdet()));
                if (stok.getMiktar().compareTo(gerekliMiktar) < 0) {
                    throw new BaseException(
                            GenericResponse.error("Yetersiz stok: " + stok.getAd(),
                                    HttpStatus.BAD_REQUEST.toString()));
                }
                stok.setMiktar(stok.getMiktar().subtract(gerekliMiktar));
                stok.setGuncelleTarih(LocalDateTime.now());
                stokKalemRepository.save(stok);
                stokHareketService.createHareket(
                        stok.getId(),
                        gerekliMiktar.negate(),
                        IslemTipEnum.CIKIS,
                        "Sipariş #" + siparisId + " için çıkış"
                );
                checkCriticalStock(stok);
            }
        }
    }

    @Override
    public void restoreStockForOrder(Long siparisId) {
        List<SiparisKalemiEntity> kalemler = siparisKalemRepository.findBySiparisId(siparisId);
        for (SiparisKalemiEntity kalem : kalemler) {
            List<MenuItemReceteEntity> receteler = menuItemReceteRepository.fetchRecetelerByMenuItemId(kalem.getMenuItem().getId());
            for (MenuItemReceteEntity recete : receteler) {
                StokKalemiEntity stok = stokKalemRepository.findById(recete.getStokKalemi().getId())
                        .orElseThrow(() -> new BaseException(
                                GenericResponse.error("Stok bulunamadı: " + recete.getStokKalemi().getAd(),
                                        HttpStatus.NOT_FOUND.toString())));
                BigDecimal geriYuklenecekMiktar = recete.getMiktar().multiply(BigDecimal.valueOf(kalem.getAdet()));
                stok.setMiktar(stok.getMiktar().add(geriYuklenecekMiktar));
                stok.setGuncelleTarih(LocalDateTime.now());
                stokKalemRepository.save(stok);
                stokHareketService.createHareket(
                        stok.getId(),
                        geriYuklenecekMiktar,
                        IslemTipEnum.GIRIS,
                        "Sipariş #" + siparisId + " iptali için geri yükleme"
                );
                checkCriticalStock(stok);
            }
        }
    }

    private void validateStockRequest(BigDecimal miktar, BigDecimal kiritikMiktar) {
        if (miktar.compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException(
                    GenericResponse.error("Miktar negatif olamaz!", HttpStatus.BAD_REQUEST.toString()));
        }
        if (kiritikMiktar.compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException(
                    GenericResponse.error("Kritik miktar negatif olamaz!", HttpStatus.BAD_REQUEST.toString()));
        }
    }

    private void checkCriticalStock(StokKalemiEntity entity) {
        if (entity.getKritikMiktar() != null && entity.getMiktar().compareTo(entity.getKritikMiktar()) <= 0) {
            logger.warn("Kritik stok uyarısı: {} (Miktar: {}, Kritik: {})",
                    entity.getAd(), entity.getMiktar(), entity.getKritikMiktar());
        }
    }

    @Override
    public String deleteStokKalem(Long id) {
        StokKalemiEntity entity = stokKalemRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Sipariş bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        Long hareketId = stokHareketRepository.fethStokKalemByHareket(entity.getId());
        if (hareketId == null) {
            GenericResponse.error("Bu stok kalemi hareket gördüğü için silinemez.", HttpStatus.BAD_REQUEST.toString());
        }
        stokKalemRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

}
