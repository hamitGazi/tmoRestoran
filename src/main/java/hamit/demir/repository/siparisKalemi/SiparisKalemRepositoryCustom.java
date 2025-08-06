package hamit.demir.repository.siparisKalemi;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;

import java.util.List;

public interface SiparisKalemRepositoryCustom {

    List<SiparisKalemiResponse> getAllSiparisKalemler();

    SiparisKalemiResponse fetchSiparisKalemiById(Long id);
}
