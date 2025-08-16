package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterRequest;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterResponse;

import java.util.List;

public interface SatisRaporService {


    List<SatisRaporFilterResponse> getSatisRaporlari(SatisRaporFilterRequest filter);




}
