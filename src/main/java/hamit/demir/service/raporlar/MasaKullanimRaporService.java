package hamit.demir.service.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.raporlar.MasaKullanimRaporFilterResponse;

import java.util.List;

public interface MasaKullanimRaporService {

    List<MasaKullanimRaporFilterResponse> getMasaKullanimRaporlari(MasaKullanimRaporFilterResponse filter);


}
