package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.raporlar.MasaKullanimRaporFilterResponse;

import java.util.List;

public interface MasaKullanimRaporRepositoryCustom {


    List<MasaKullanimRaporFilterResponse> fetchMasaKullanimRaporlari(MasaKullanimRaporFilterResponse filter);
}
