package hamit.demir.service.personel;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.personel.PersonelResponse;
import hamit.demir.model.dto.personel.PersonelSaveRequest;
import hamit.demir.model.dto.personel.PersonelUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface PersonelService {

    List<PersonelResponse> getAllPersonel();

    PersonelResponse getPersonelById(Long id);

    Long savePersonel(PersonelSaveRequest request);

    Long updatePersonel(PersonelUpdateRequest request);

    String deletePersonel(Long id);
}
