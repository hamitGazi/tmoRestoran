package hamit.demir.service.odeme;

import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.odeme.OdemeSaveRequest;
import hamit.demir.model.dto.odeme.OdemeUpdateRequest;
import hamit.demir.model.entity.OdemeEntity;
import hamit.demir.repository.odeme.OdemeRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericRespose;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OdemeServiceImpl implements OdemeService {

    private final OdemeRepository odemeRepository;
    private final SiparisRepository siparisRepository;

    @Override
    public List<OdemeResponse> getAllOdemeler() {
        return odemeRepository.fetchAllOdemeler();
    }

    @Override
    public OdemeResponse getOdemeById(Long id) {
        return odemeRepository.fetchOdemeById(id);
    }

    @Override
    public Long saveOdeme(OdemeSaveRequest request) {
        OdemeEntity entity = new OdemeEntity();
        entity.setTutar(request.tutar());
        entity.setYontemi(request.yontemi());
        entity.setOdemeDurum(request.durum());
        entity.setSiparis(siparisRepository.getReferenceById(request.siparisId()));
        entity.setOdemeZamani(LocalDateTime.now());
        return odemeRepository.save(entity).getId();
    }

    @Override
    public Long updateOdeme(OdemeUpdateRequest request) {
        OdemeEntity entity = odemeRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("Odeme Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));

        entity.setOdemeDurum(request.durum());
        entity.setOdemeZamani(LocalDateTime.now());

        return odemeRepository.save(entity).getId();
    }

    @Override
    public String deleteOdeme(Long id) {
        OdemeEntity entity = odemeRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("Odeme Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        odemeRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

}
