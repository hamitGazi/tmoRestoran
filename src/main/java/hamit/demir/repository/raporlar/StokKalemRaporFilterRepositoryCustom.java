package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.raporlar.stokKalem.StokKalemRaporResponse;
import hamit.demir.model.dto.raporlar.stokKalem.StokRaporFilterRequest;

import java.util.List;

public interface StokKalemRaporFilterRepositoryCustom {


    List<StokKalemRaporResponse> fetchStokRaporlari(StokRaporFilterRequest filter);
}
