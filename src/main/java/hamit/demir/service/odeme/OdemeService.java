package hamit.demir.service.odeme;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.odeme.OdemeSaveRequest;
import hamit.demir.model.dto.odeme.OdemeUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface OdemeService {

    List<OdemeResponse> getAllOdemeler();

    OdemeResponse getOdemeById(Long id);

    Long saveOdeme(OdemeSaveRequest request);

    Long updateOdeme(OdemeUpdateRequest request);

    String deleteOdeme(Long id);
}
