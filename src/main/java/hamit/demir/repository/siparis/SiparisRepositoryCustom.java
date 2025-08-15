package hamit.demir.repository.siparis;

import hamit.demir.model.dto.siparis.SiparisAllResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;

import java.util.List;

public interface SiparisRepositoryCustom {

    List<SiparisAllResponse> getAllSiparisler();

    SiparisAllResponse fetchSiparisById(Long id);



}
