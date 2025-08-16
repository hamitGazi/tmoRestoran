package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.stokKalem.StokKalemRaporResponse;
import hamit.demir.model.dto.raporlar.stokKalem.StokRaporFilterRequest;

import java.util.List;

public interface StokKalemRaporService {


    List<StokKalemRaporResponse> getStokRaporlari(StokRaporFilterRequest filter);
}
