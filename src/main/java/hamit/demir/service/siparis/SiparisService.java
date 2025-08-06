package hamit.demir.service.siparis;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.siparis.SiparisResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface SiparisService {


    List<SiparisResponse> getAllSiparisler();

    SiparisResponse getSiparisById(Long id);

    Long saveSiparis(SiparisSaveRequest request);

    Long updateSiparis(SiparisUpdateRequest request);

    String deleteSiparis(Long id);
}
