package hamit.demir.service.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.SatisRaporFilterResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface SatisRaporService {


    List<SatisRaporFilterResponse> getSatisRaporlari(SatisRaporFilterResponse filter);




}
