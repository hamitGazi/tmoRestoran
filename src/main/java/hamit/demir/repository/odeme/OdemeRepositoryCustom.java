package hamit.demir.repository.odeme;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.entity.OdemeEntity;

import java.util.List;

public interface OdemeRepositoryCustom {

    List<OdemeResponse> fetchAllOdemeler();

    OdemeResponse fetchOdemeById(Long id);

    OdemeEntity fethOdemeBYSiparisId(Long id);
}
