package hamit.demir.repository;

import hamit.demir.model.dto.masa.MasaResponse;

import java.util.List;

public interface MasaRepositoryCustom {
    List<MasaResponse> fetchAllMasalar();

    MasaResponse fetchMasaById(Long id);

    List<MasaResponse> fetchMasaByNotRezervasyon();
}
