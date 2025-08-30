package hamit.demir.repository.rezervasyonSureAyar;

import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarResponse;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.entity.EtkinlikTipEnum;
import hamit.demir.model.entity.RezervasyonSureAyarEntity;

import java.util.List;

public interface RezervasyonSureAyarRepositoryCustom {



    RezervasyonSureAyarEntity fetchByEtkinlikTip(EtkinlikTipEnum etkinlikTip);

    List<RezervasyonSureAyarResponse> fetchAllRezervasyonSureAyarlar();

    RezervasyonSureAyarResponse fetchRezervasyonSureAyarById(Long id);
}
