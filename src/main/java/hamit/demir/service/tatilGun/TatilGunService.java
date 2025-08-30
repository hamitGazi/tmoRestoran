package hamit.demir.service.tatilGun;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.tatilGun.TatilGunResponse;
import hamit.demir.model.dto.tatilGun.TatilGunSaveRequest;
import hamit.demir.model.dto.tatilGun.TatilGunUpdateRequest;
import hamit.demir.model.entity.MasaDurumu;

import java.time.LocalDateTime;
import java.util.List;

public interface TatilGunService {

    
    Long saveTatilGun(TatilGunSaveRequest request);

    Long updateTatilGun(TatilGunUpdateRequest request);

    String deleteTatilGunById(Long id);

    String loadResmiTatiller();

    Boolean uygunTarih(LocalDateTime dateTime);

    List<TatilGunResponse> getAllTatilGunleri();

    TatilGunResponse getTatilGunById(Long id);

    List<TatilGunResponse> getTatilGunByCalismaZamanId(Long calismaZamanId);
}
