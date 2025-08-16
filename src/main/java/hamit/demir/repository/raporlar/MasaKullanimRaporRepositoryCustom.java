package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.raporlar.masaKullanim.MasaKulanimRaporFilterResponse;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKullanimRaporFilterRequest;

import java.util.List;

public interface MasaKullanimRaporRepositoryCustom {


    List<MasaKulanimRaporFilterResponse> fetchMasaKullanimRaporlari(MasaKullanimRaporFilterRequest filter);
}
