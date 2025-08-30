package hamit.demir.repository;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.tatilGun.TatilGunResponse;
import hamit.demir.model.entity.TatilGunEntity;

import java.time.LocalDate;
import java.util.List;

public interface MasaRepositoryCustom {


    List<MasaResponse> fetchAllMasalar();

    MasaResponse fetchMasaById(Long id);

    List<MasaResponse> fetchMasaByNotRezervasyon();
}
