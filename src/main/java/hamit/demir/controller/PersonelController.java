package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.personel.PersonelAllResponse;
import hamit.demir.model.dto.personel.PersonelSaveRequest;
import hamit.demir.model.dto.personel.PersonelUpdateRequest;
import hamit.demir.model.entity.PersonelRol;
import hamit.demir.service.personel.PersonelService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("personel")
@RequiredArgsConstructor
public class PersonelController {

    private final PersonelService personelServicee;

    @GetMapping("rol-enum")
    public GenericResponse<List<EnumRecord>> getAllRolEnum() {

        List<EnumRecord> enumRecords = PersonelRol.personelRolEnumList();
        return GenericResponse.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericResponse<List<PersonelAllResponse>> getAllPersonel() {
        List<PersonelAllResponse> allPersonel = personelServicee.getAllPersonel();
        return GenericResponse.ok(allPersonel);
    }

    @GetMapping("/{id}")
    public PersonelAllResponse getPersonelById(@PathVariable Long id) {
        return personelServicee.getPersonelById(id);
    }

    @PostMapping("save")
    public GenericResponse<Long> savePersonel(@Valid @RequestBody PersonelSaveRequest request) {

        Long id = personelServicee.savePersonel(request);
        return GenericResponse.ok(id);
    }

    @PutMapping
    public GenericResponse<Long> updatePersonel(@Valid @RequestBody PersonelUpdateRequest request) {

        Long id = personelServicee.updatePersonel(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public String deletePersonel(@PathVariable Long id) {
        return personelServicee.deletePersonel(id);
    }


}
