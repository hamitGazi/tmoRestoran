package hamit.demir.repository.stokKalem;

import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.masa.MasaResponse;

import java.util.List;

public interface StokKalemRepositoryCustom {

    List<StokKalemiResponse> fetchAllStokKalemler();

    StokKalemiResponse fetchStokKalemById(Long id);
}
