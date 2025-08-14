package hamit.demir.service.personel;

import hamit.demir.model.dto.personel.PersonelAllResponse;
import hamit.demir.model.dto.personel.PersonelSaveRequest;
import hamit.demir.model.dto.personel.PersonelUpdateRequest;

import java.util.List;

public interface PersonelService {

    List<PersonelAllResponse> getAllPersonel();

    PersonelAllResponse getPersonelById(Long id);

    Long savePersonel(PersonelSaveRequest request);

    Long updatePersonel(PersonelUpdateRequest request);

    String deletePersonel(Long id);
}
