package hamit.demir.service.sipariKalemi;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import hamit.demir.model.entity.SiparisKalemiEntity;
import hamit.demir.repository.menuItem.MenuItemRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.repository.siparisKalemi.SiparisKalemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericRespose;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SiparisKalemiServiceImpl implements SiparisKalemiService {
    private final SiparisKalemRepository siparisKalemiRepository;
    private final SiparisRepository siparisRepository;
    private final MenuItemRepository menuItemRepository;


    @Override
    public List<SiparisKalemiResponse> getAllSiparisKalemler() {
        return siparisKalemiRepository.getAllSiparisKalemler();
    }

    @Override
    public SiparisKalemiResponse getSiparisKalemiById(Long id) {
        return siparisKalemiRepository.fetchSiparisKalemiById(id);
    }

    @Override
    public Long saveSiparisKalemi(SiparisKalemiSaveRequest request) {
        SiparisKalemiEntity entity = new SiparisKalemiEntity();
        entity.setSiparis(siparisRepository.getReferenceById(request.siparisId()));
        entity.setMenuItem(menuItemRepository.getReferenceById(request.menuItemId()));
        entity.setAdet(request.adet());
        entity.setEkOzellikler(request.ekOzellikler());
        entity.setNot(request.not());

        return siparisKalemiRepository.save(entity).getId();
    }

    @Override
    public Long updateSiparisKalemi(SiparisKalemiUpdateRequest request) {
        SiparisKalemiEntity entity = siparisKalemiRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("SiparisKalemi Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));

        entity.setAdet(request.adet());
        entity.setEkOzellikler(request.ekOzellikler());
        entity.setNot(request.not());
        return siparisKalemiRepository.save(entity).getId();
    }

    @Override
    public String deleteSiparisKalemi(Long id) {
        SiparisKalemiEntity entity = siparisKalemiRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("SiparisKalemi Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        siparisKalemiRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }


}
