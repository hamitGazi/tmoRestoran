package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.raporlar.SatisRaporFilterResponse;

import java.util.List;

public interface SatisRaporRepositoryCustom {

    List<SatisRaporFilterResponse> fetchSatisRaporlari(SatisRaporFilterResponse filter);
}
