package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterRequest;
import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterResponse;

import java.util.List;

public interface GeriBildirimRaporService {

    List<GeriBildirimRaporFilterResponse> getGeriBildirimRaporlari(GeriBildirimRaporFilterRequest filter);


}
