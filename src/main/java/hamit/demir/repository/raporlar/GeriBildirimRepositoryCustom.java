package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.raporlar.GeriBildirimRaporFilterResponse;

import java.util.List;

public interface GeriBildirimRepositoryCustom {


    List<GeriBildirimRaporFilterResponse> fetchGeriBildirimRaporlari(GeriBildirimRaporFilterResponse filter);
}
