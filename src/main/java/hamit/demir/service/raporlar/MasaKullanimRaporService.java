package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.masaKullanim.MasaKulanimRaporFilterResponse;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKullanimRaporFilterRequest;

import java.util.List;

public interface MasaKullanimRaporService {

    List<MasaKulanimRaporFilterResponse> getMasaKullanimRaporlari(MasaKullanimRaporFilterRequest filter);


}
