package hamit.demir.service.sipariKalemi;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface SiparisKalemiService {


    List<SiparisKalemiResponse> getAllSiparisKalemler();

    SiparisKalemiResponse getSiparisKalemiById(Long id);

    Long saveSiparisKalemi(SiparisKalemiSaveRequest request);



    String deleteSiparisKalemi(Long id);

   List< SiparisKalemiResponse> getKalemlerBySiparisId(Long id);

    Long updateSiparisKalemi(@Valid SiparisKalemiUpdateRequest request);
}
