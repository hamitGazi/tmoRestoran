package hamit.demir.service.siparis;

import hamit.demir.model.dto.siparis.SiparisAllResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;

import java.util.List;

public interface SiparisService {


    List<SiparisAllResponse> getAllSiparisler();

    SiparisAllResponse getSiparisById(Long id);
    Long saveSiparis(SiparisSaveRequest request);

    Long updateSiparis(SiparisUpdateRequest request);

    String deleteSiparis(Long id);

    void siparisOdmeAndUpdateStok(Long odemeId);

}
