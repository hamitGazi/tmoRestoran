package hamit.demir.service.sipariKalemi;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import hamit.demir.model.entity.SiparisKalemiEntity;
import hamit.demir.repository.menuFiyat.MenuFiyatRepository;
import hamit.demir.repository.menuItem.MenuItemRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.repository.siparisKalemi.SiparisKalemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SiparisKalemiServiceImpl implements SiparisKalemiService {
    private final SiparisKalemRepository siparisKalemiRepository;
    private final SiparisRepository siparisRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuFiyatRepository menuFiyatRepository;


    @Override
    public List<SiparisKalemiResponse> getAllSiparisKalemler() {
        return siparisKalemiRepository.fetchAllSiparisKalemler();
    }

    @Override
    public SiparisKalemiResponse getSiparisKalemiById(Long id) {
        return siparisKalemiRepository.fetchSiparisKalemiById(id);
    }

    @Override
    public Long saveSiparisKalemi(SiparisKalemiSaveRequest request) {
        SiparisKalemiEntity entity = new SiparisKalemiEntity();
        BigDecimal menuFiyat = menuFiyatRepository.fetchMenuItemFiyat(request.menuItem());
        entity.setSiparis(siparisRepository.getReferenceById(request.siparis()));
        entity.setMenuItem(menuItemRepository.getReferenceById(request.menuItem()));
        entity.setAdet(request.adet());
        entity.setEkOzellikler(request.ekOzellikler());
        entity.setKalemNot(request.kalemNot());
        entity.setBirimFiyat(menuFiyat);
        BigDecimal toplamFiyat = menuFiyat.multiply(BigDecimal.valueOf(request.adet()));
        entity.setToplamFiyat(toplamFiyat);
        SiparisKalemiEntity save = siparisKalemiRepository.save(entity);
        return save.getId();
    }


    @Override
    public String deleteSiparisKalemi(Long id) {
        SiparisKalemiEntity entity = siparisKalemiRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("SiparisKalemi Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        siparisKalemiRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

    @Override
    public List<SiparisKalemiResponse> getKalemlerBySiparisId(Long id) {
        return siparisKalemiRepository.fetchKalemlerBySiparisId(id);

    }

    @Override
    public Long updateSiparisKalemi(SiparisKalemiUpdateRequest request) {
        SiparisKalemiEntity entity = siparisKalemiRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("SiparisKalemi Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        BigDecimal menuFiyat = menuFiyatRepository.fetchMenuItemFiyat(request.menuItem());
        entity.setSiparis(siparisRepository.getReferenceById(request.siparis()));
        entity.setMenuItem(menuItemRepository.getReferenceById(request.menuItem()));
        entity.setAdet(request.adet());
        entity.setEkOzellikler(request.ekOzellikler());
        entity.setKalemNot(request.kalemNot());
        entity.setBirimFiyat(menuFiyat);
        BigDecimal toplamFiyat = menuFiyat.multiply(BigDecimal.valueOf(request.adet()));
        entity.setToplamFiyat(toplamFiyat);
        return siparisKalemiRepository.save(entity).getId();


    }

    @Override
    public List<SiparisKalemiResponse> getKalemlerByMasaId(Long id) {
        return siparisKalemiRepository.fetchKalemlerByMasaId(id);
    }

    @Override
    public String deleteSiparisKalem(Long id) {
        SiparisKalemiEntity siparisKalemiEntity = siparisKalemiRepository.findById(id).orElseThrow(() -> new BaseException(
                GenericResponse.error("Siparis kalemi bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        siparisKalemiRepository.deleteById(siparisKalemiEntity.getId());
        return "Silme işlemi başarılı";
    }


}
