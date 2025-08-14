package hamit.demir.repository.personel;

import hamit.demir.model.dto.personel.PersonelAllResponse;

import java.util.List;

public interface PersonelRepositoryCustom {

    List<PersonelAllResponse> fetchAllPersonel();

    PersonelAllResponse fetchPersonelById(Long id);
}
