package hamit.demir.service.musteri;

import hamit.demir.model.dto.musteri.MusteriResponse;
import hamit.demir.model.dto.musteri.MusteriSaveRequest;
import hamit.demir.model.dto.musteri.MusteriUpdateRequest;
import hamit.demir.model.entity.MusteriEntity;
import hamit.demir.repository.musteri.MusteriRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusteriServiceImpl implements MusteriService {

    private final MusteriRepository musteriRepository;

    @Override
    public List<MusteriResponse> getAllMusterler() {
        return musteriRepository.fetchAllMusterler();
    }

    @Override
    public MusteriResponse getMusteriById(Long id) {
        return musteriRepository.fetchMusteriById(id);
    }

    @Override
    public Long saveMusteri(MusteriSaveRequest request) {
        MusteriEntity entity = new MusteriEntity();
       entity.setAd(request.ad());
       entity.setSoyad(request.soyad());
       entity.setTelefon(request.telefon());
       entity.setEmail(request.email());
       entity.setAdres(request.adres());
   /*    entity.setSifre(request.sifre());*/
       entity.setOlusturmaTarih(LocalDateTime.now());

        return musteriRepository.save(entity).getId();
    }

    @Override
    public Long updateMusteri(MusteriUpdateRequest request) {
        MusteriEntity entity = musteriRepository.findById(request.id())

                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Musteri Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        entity.setAd(request.ad());
        entity.setSoyad(request.soyad());
        entity.setTelefon(request.telefon());
        entity.setEmail(request.email());
        entity.setAdres(request.adres());
        entity.setGuncelleTarih(LocalDateTime.now());
        return musteriRepository.save(entity).getId();
    }

    @Override
    public String deleteMusteri(Long id) {
        MusteriEntity entity = musteriRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Musteri Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        musteriRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

}
