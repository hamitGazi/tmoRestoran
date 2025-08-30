package hamit.demir.service;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.entity.MasaDurumu;

import java.util.List;

public interface MasaService {
    List<MasaResponse> getAllMasalar();

    MasaResponse getMasaById(Long id);
    

    Long saveMasa( MasaSaveRequest request);

    Long updateMasa( MasaUpdateRequest request);

    String deleteMasa(Long id);

    List<MasaResponse> getMasaByNotRezervasyon();

    void updateMasaDurumu(Long masaId, MasaDurumu yeniDurum);
}
