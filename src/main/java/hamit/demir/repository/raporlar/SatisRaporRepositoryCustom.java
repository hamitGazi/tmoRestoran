package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterRequest;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterResponse;

import java.util.List;

public interface SatisRaporRepositoryCustom {

    List<SatisRaporFilterResponse> fetchSatisRaporlari(SatisRaporFilterRequest filter);
}
