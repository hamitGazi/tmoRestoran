package hamit.demir.service.calismaZaman;

import hamit.demir.model.dto.calisZaman.CalismaZamanResponse;
import hamit.demir.model.dto.calisZaman.CalismaZamanSaveRequest;
import hamit.demir.model.dto.calisZaman.CalismaZamanUpdateRequest;
import hamit.demir.model.entity.CalismaZamanEntity;
import hamit.demir.repository.calismaZaman.CalismaZamanRepository;
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
public class CalismaZamanServiceImpl implements CalismaZamanService {


    private final CalismaZamanRepository calismaZamanRepository;

    @Override
    public List<CalismaZamanResponse> getAllCalismaZamanlar() {
        return calismaZamanRepository.fetchAllCalismaZamanlar();

    }

    @Override
    public CalismaZamanResponse getCalismaZamanById(Long id) {
        return calismaZamanRepository.fetchCalismaZamanById(id);
    }

    @Override
    public Long saveCalismaZaman(CalismaZamanSaveRequest request) {
        CalismaZamanEntity entity = new CalismaZamanEntity();
        entity.setGun(request.gun());
        entity.setAcilisSaat(request.acilisSaati());
        entity.setKapanisSaat(request.kapanisSaati());
        entity.setTatil(request.tatil() != null ? request.tatil() : false);
        /*entity.setOzelEtkinlikTip(request.ozelEtkinlikTip());*/
        entity.setIstisna(request.istisna() != null ? request.istisna() : false);
        entity.setAktif(request.aktif() != null ? request.aktif() : true);
        entity.setAciklama(request.aciklama());

        return calismaZamanRepository.save(entity).getId();
    }

    @Override
    public Long updateCalismaZaman(CalismaZamanUpdateRequest request) {
        CalismaZamanEntity entity = calismaZamanRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Güncelleme için kayıt bulunamadı!",
                        HttpStatus.NOT_FOUND.toString()
                )));
        entity.setGun(request.gun());
        entity.setAcilisSaat(request.acilisSaati());
        entity.setKapanisSaat(request.kapanisSaati());
        entity.setTatil(request.tatil() != null ? request.tatil() : false);
        //entity.setOzelEtkinlikTip(request.ozelEtkinlikTip());
        entity.setIstisna(request.istisna() != null ? request.istisna() : false);
        entity.setAktif(request.aktif() != null ? request.aktif() : true);
        entity.setAciklama(request.aciklama());
        return calismaZamanRepository.save(entity).getId();
    }

    @Override
    public String deleteCalismaZamanById(Long id) {
        CalismaZamanEntity entity = calismaZamanRepository.findById(id)
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Silinecek kayıt bulunamadı!",
                        HttpStatus.NOT_FOUND.toString()
                )));
        calismaZamanRepository.delete(entity);
        return "Silindi";
    }

    @Override
    public Boolean UygunZaman(LocalDateTime dateTime) {
       /* CalismaGunEnum gun = CalismaGunEnum.fromLocalDate(dateTime.toLocalDate());
        CalismaZamanEntity calismaZaman = calismaZamanRepository.fetchGecerliCalismaZaman(gun);

        if (calismaZaman == null) {
            return false; // O gün için aktif çalışma zamanı tanımlı değil
        }
        if (Boolean.TRUE.equals(calismaZaman.getTatil())) {// null kontorlu de yapar
            return false; // Tatil günü, uygun değil
        }

        if (calismaZaman.getBitisTarihi() != null &&
                dateTime.toLocalDate().isAfter(calismaZaman.getBitisTarihi())) {
            return false; // Tanımın geçerlilik süresi dolmuş
        }

        LocalTime saat = dateTime.toLocalTime();
        LocalTime acilis = calismaZaman.getAcilisSaati();
        LocalTime kapanis = calismaZaman.getKapanisSaati();

        if (saat.isBefore(acilis)) {
            return false; // Saat açılış saatinden önce
        }

        if (saat.isAfter(kapanis)) {
            return false; // Saat kapanış saatinden sonra
        }*/

        return true; // Tüm kurallar sağlandı, saat uygun
    }


    @Override
    public List<CalismaZamanResponse> getAktifIstisnaZaman() {
        return calismaZamanRepository.fetchAktifIstisnaZaman();
    }


}

