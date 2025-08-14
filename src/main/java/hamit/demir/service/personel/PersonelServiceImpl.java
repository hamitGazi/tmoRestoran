package hamit.demir.service.personel;

import hamit.demir.model.dto.personel.PersonelAllResponse;
import hamit.demir.model.dto.personel.PersonelSaveRequest;
import hamit.demir.model.dto.personel.PersonelUpdateRequest;
import hamit.demir.model.entity.PersonelEntity;
import hamit.demir.repository.personel.PersonelRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonelServiceImpl implements PersonelService {

    private final PersonelRepository personelRepository;

    @Override
    public List<PersonelAllResponse> getAllPersonel() {
        return personelRepository.fetchAllPersonel();
    }

    @Override
    public PersonelAllResponse getPersonelById(Long id) {
        return personelRepository.fetchPersonelById(id);
    }

    @Override
    public Long savePersonel(PersonelSaveRequest request) {
        PersonelEntity entity = new PersonelEntity();
      entity.setAd(request.ad());
      entity.setSoyad(request.soyad());
      entity.setEmail(request.email());
      entity.setSifre(request.sifre());
      entity.setRol(request.rol());
      entity.setAktif(request.aktif());
      entity.setOlusturTarih(LocalDateTime.now());
        return personelRepository.save(entity).getId();
    }

    @Override
    public Long updatePersonel(PersonelUpdateRequest request) {
        PersonelEntity entity = personelRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Personel Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        entity.setAd(request.ad());
        entity.setSoyad(request.soyad());

        entity.setRol(request.rol());
        entity.setAktif(request.aktif());
        entity.setGuncelleTarih(LocalDateTime.now());
        return personelRepository.save(entity).getId();
    }

    @Override
    public String deletePersonel(Long id) {
        PersonelEntity entity = personelRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Personel Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        personelRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }
}
