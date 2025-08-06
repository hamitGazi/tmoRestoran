package hamit.demir.service.siparis;

import hamit.demir.model.dto.siparis.SiparisResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import hamit.demir.model.entity.SiparisEntity;
import hamit.demir.repository.MasaRepository;
import hamit.demir.repository.personel.PersonelRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericRespose;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SiparisServiceImpl implements SiparisService {
    private final SiparisRepository siparisRepository;
    private final MasaRepository masaRepository;
    private final PersonelRepository personelRepository;

    @Override
    public List<SiparisResponse> getAllSiparisler() {
        return siparisRepository.getAllSiparisler();
    }

    @Override
    public SiparisResponse getSiparisById(Long id) {
        return siparisRepository.fetchSiparisById(id);
    }

    @Override
    public Long saveSiparis(SiparisSaveRequest request) {
        SiparisEntity entity = new SiparisEntity();
        entity.setMasa(masaRepository.getReferenceById(request.masaId()));
        entity.setPersonel(personelRepository.getReferenceById(request.personelId()));
        entity.setMusteriAd(request.musteriAd());
        entity.setNot(request.not());
        entity.setOlusturmaZamani(LocalDateTime.now());
        return siparisRepository.save(entity).getId();
    }

    @Override
    public Long updateSiparis(SiparisUpdateRequest request) {
        SiparisEntity entity = siparisRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("Siparis Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));

        entity.setSiparisDurumu(request.durum());
        entity.setNot(request.not());

        return siparisRepository.save(entity).getId();
    }

    @Override
    public String deleteSiparis(Long id) {
        SiparisEntity entity = siparisRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("Siparis Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        siparisRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }
}
