package hamit.demir.repository.raporlar;

import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterRequest;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterResponse;

import java.util.List;

public interface PersonelRaporRepositoryCustom {

    List<PersonelRaporFilterResponse> fetchPersonelRaporlari(PersonelRaporFilterRequest filter);
}
