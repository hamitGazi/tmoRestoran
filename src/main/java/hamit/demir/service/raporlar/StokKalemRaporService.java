package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.StokRaporFilterResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface StokKalemRaporService {


    List<StokRaporFilterResponse> getStokRaporlari(StokRaporFilterResponse filter);
}
