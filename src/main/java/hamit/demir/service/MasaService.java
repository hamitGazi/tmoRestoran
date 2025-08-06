package hamit.demir.service;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface MasaService {
    List<MasaResponse> getAllMasalar();

    MasaResponse getMasaById(Long id);
    

    Long saveMasa( MasaSaveRequest request);

    Long updateMasa(@Valid MasaUpdateRequest request);

    String deleteMasa(Long id);
}
