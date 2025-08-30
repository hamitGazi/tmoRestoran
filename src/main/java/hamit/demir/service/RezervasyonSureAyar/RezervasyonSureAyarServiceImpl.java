package hamit.demir.service.RezervasyonSureAyar;


import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarResponse;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarSaveRequest;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarUpdateRequest;
import hamit.demir.model.entity.EtkinlikTipEnum;
import hamit.demir.model.entity.RezervasyonSureAyarEntity;
import hamit.demir.repository.rezervasyonSureAyar.RezervasyonSureAyarRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class RezervasyonSureAyarServiceImpl implements RezervasyonSureAyarService {
    private final RezervasyonSureAyarRepository rezervasyonSureAyarRepository;

    @Override
    public List<RezervasyonSureAyarResponse> getAllRezervasyonSureAyarlar() {

        return rezervasyonSureAyarRepository.fetchAllRezervasyonSureAyarlar();
    }

    @Override
    public RezervasyonSureAyarResponse getRezervasyonSureAyarById(Long id) {
        return rezervasyonSureAyarRepository.fetchRezervasyonSureAyarById(id);
    }

    @Override
    public Set<Integer> getSureAyarListEtkinlikTipById(EtkinlikTipEnum etkinlikTip) {
        RezervasyonSureAyarEntity sureAyar = rezervasyonSureAyarRepository.fetchByEtkinlikTip(etkinlikTip);
               if(sureAyar==null) {
                   throw  new BaseException(
                           GenericResponse.error("Etkinlik tipi için süre ayarı bulunamadı veya aktif değil!", HttpStatus.BAD_REQUEST.toString()));
               }
        Set<Integer> sureSecenekleri = new LinkedHashSet<>();
            sureSecenekleri.add(sureAyar.getVarsayilanSure());
        for (int s = sureAyar.getMinSure(); s <= sureAyar.getMaxSure(); s += 30) {
                sureSecenekleri.add(s);
        }
        return sureSecenekleri;
    }



    @Override
    public Long saveRezervasyonSureAyar(RezervasyonSureAyarSaveRequest request) {
        RezervasyonSureAyarEntity entity = new RezervasyonSureAyarEntity();
        entity.setAktif(request.aktif());
        entity.setMaxSure(request.maxSure());
        entity.setMinSure(request.minSure());
        entity.setVarsayilanSure(request.varsayilanSure());
        entity.setEtkinlikTip(request.etkinlikTip());
        entity.setOzelDurumEsnekligi(request.ozelDurumEsnekligi());
        return rezervasyonSureAyarRepository.save(entity).getId();
    }

    @Override
    public Long updateRezervasyonSureAyar(RezervasyonSureAyarUpdateRequest request) {
        RezervasyonSureAyarEntity entity = rezervasyonSureAyarRepository.findById(request.id()).orElseThrow(() -> new BaseException(
                GenericResponse.error("Rezervasyon süresi bulunamadı..", HttpStatus.NOT_FOUND.toString())));
        entity.setAktif(request.aktif());
        entity.setMaxSure(request.maxSure());
        entity.setMinSure(request.minSure());
        entity.setVarsayilanSure(request.varsayilanSure());
        entity.setEtkinlikTip(request.etkinlikTip());
        entity.setOzelDurumEsnekligi(request.ozelDurumEsnekligi());
        return rezervasyonSureAyarRepository.save(entity).getId();
    }

    @Override
    public String deleteRezervayonSureAyar(Long id) {
        RezervasyonSureAyarEntity entity = rezervasyonSureAyarRepository.findById(id).orElseThrow(() -> new BaseException(
                GenericResponse.error("Rezervasyon  süresi bulunamadı..", HttpStatus.NOT_FOUND.toString())));
        rezervasyonSureAyarRepository.deleteById(entity.getId());
        return "Silme işlemi gerçekleştirildi.";
    }


}
