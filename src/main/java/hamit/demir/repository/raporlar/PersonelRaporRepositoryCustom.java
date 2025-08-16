package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.raporlar.PersonelRaporFilterResponse;

import java.util.List;

public interface PersonelRaporRepositoryCustom {

    List<PersonelRaporFilterResponse> fetchPersonelRaporlari(PersonelRaporFilterResponse filter);
}
