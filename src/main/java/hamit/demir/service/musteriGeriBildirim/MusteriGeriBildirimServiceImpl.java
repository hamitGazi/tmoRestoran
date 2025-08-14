package hamit.demir.service.musteriGeriBildirim;

import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimSaveRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimUpdateRequest;
import hamit.demir.model.entity.MusteriGeriBildirimEntity;
import hamit.demir.repository.musteriGeriBildirim.MusteriGeriBildirimRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MusteriGeriBildirimServiceImpl implements MusteriGeriBildirimService {
    private final MusteriGeriBildirimRepository musteriGeriBildirimRepository;
    private final SiparisRepository siparisRepository;

    @Override
    public List<MusteriGeriBildirimResponse> getAllMusteriGeriBildirimler() {
        return musteriGeriBildirimRepository.fetchAllMusteriGeriBildirims();
    }

    @Override
    public MusteriGeriBildirimResponse getMusteriGeriBildirimById(Long id) {
        return musteriGeriBildirimRepository.fetchMusteriGeriBildirimById(id);
    }

    @Override
    public Long saveMusteriGeriBildirim(MusteriGeriBildirimSaveRequest request) {
        MusteriGeriBildirimEntity entity = new MusteriGeriBildirimEntity();
      entity.setSiparis(request.siparis());
      entity.setYorum(request.yorum());
      entity.setMusteriAd(request.musteriAd());
      entity.setPuan(request.puan());
      entity.setGeriBildirimTur(request.geriBildirimtur());
      entity.setOlusturmaTarih(LocalDateTime.now());
        return musteriGeriBildirimRepository.save(entity).getId();
    }

    @Override
    public Long updateMusteriGeriBildirim(MusteriGeriBildirimUpdateRequest request) {
        MusteriGeriBildirimEntity entity  = musteriGeriBildirimRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("MusteriGeriBildirim Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        entity.setSiparis(request.siparis());
        entity.setYorum(request.yorum());
        entity.setMusteriAd(request.musteriAd());
        entity.setPuan(request.puan());
        entity.setGeriBildirimTur(request.geriBildirimtur());
        entity.setGuncelleTarih(LocalDateTime.now());
        return musteriGeriBildirimRepository.save(entity).getId();
    }

    @Override
    public String deleteMusteriGeriBildirim(Long id) {
        MusteriGeriBildirimEntity entity = musteriGeriBildirimRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("MusteriGeriBildirim Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        musteriGeriBildirimRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }


}
