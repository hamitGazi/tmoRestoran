package hamit.demir.service.RezervasyonSureAyar;

import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarResponse;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarSaveRequest;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarUpdateRequest;
import hamit.demir.model.entity.EtkinlikTipEnum;

import java.util.List;
import java.util.Set;

public interface RezervasyonSureAyarService {
    List<RezervasyonSureAyarResponse> getAllRezervasyonSureAyarlar();

    RezervasyonSureAyarResponse getRezervasyonSureAyarById(Long id);

    Long saveRezervasyonSureAyar(RezervasyonSureAyarSaveRequest request);

    Long updateRezervasyonSureAyar(RezervasyonSureAyarUpdateRequest request);

    String deleteRezervayonSureAyar(Long id);

    Set<Integer> getSureAyarListEtkinlikTipById(EtkinlikTipEnum etkinlikTip);


}
