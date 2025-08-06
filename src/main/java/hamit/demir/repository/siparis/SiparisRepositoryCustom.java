package hamit.demir.repository.siparis;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.siparis.SiparisResponse;

import java.util.List;

public interface SiparisRepositoryCustom {

    List<SiparisResponse> getAllSiparisler();

    SiparisResponse fetchSiparisById(Long id);
}
