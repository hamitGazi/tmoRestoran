package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterRequest;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterResponse;

import java.util.List;

public interface PersonelRaporService {



    List<PersonelRaporFilterResponse> getPersonelRaporlari(PersonelRaporFilterRequest filter);
}
