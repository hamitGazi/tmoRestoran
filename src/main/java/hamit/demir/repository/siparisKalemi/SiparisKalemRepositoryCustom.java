package hamit.demir.repository.siparisKalemi;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.entity.SiparisKalemiEntity;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface SiparisKalemRepositoryCustom {

    List<SiparisKalemiResponse> fetchAllSiparisKalemler();

    SiparisKalemiResponse fetchSiparisKalemiById(Long id);

    List<SiparisKalemiEntity> fetchSiparisKalemiListBySiparisId(@NotNull Long aLong);

    List<SiparisKalemiResponse> fetchKalemlerBySiparisId(Long id);

    List<SiparisKalemiResponse> fetchKalemlerByMasaId(Long id);
}
