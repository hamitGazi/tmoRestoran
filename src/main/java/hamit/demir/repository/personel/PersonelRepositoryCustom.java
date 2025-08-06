package hamit.demir.repository.personel;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.personel.PersonelResponse;

import java.util.List;

public interface PersonelRepositoryCustom {

    List<PersonelResponse> fetchAllPersonel();

    PersonelResponse fetchPersonelById(Long id);
}
