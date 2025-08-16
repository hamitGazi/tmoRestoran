package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.raporlar.StokRaporFilterResponse;

import java.util.List;

public interface StokRaporFilterRepositoryCustom {


    List<StokRaporFilterResponse> fetchStokRaporlari(StokRaporFilterResponse filter);
}
