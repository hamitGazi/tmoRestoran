package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterRequest;
import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterResponse;

import java.util.List;

public interface GeriBildirimRepositoryCustom {


    List<GeriBildirimRaporFilterResponse> fetchGeriBildirimRaporlari(GeriBildirimRaporFilterRequest filter);
}
