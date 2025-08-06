package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.personel.PersonelResponse;
import hamit.demir.model.dto.personel.PersonelSaveRequest;
import hamit.demir.model.dto.personel.PersonelUpdateRequest;
import hamit.demir.model.entity.PersonelRol;
import hamit.demir.service.MasaService;
import hamit.demir.service.personel.PersonelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personel")
@RequiredArgsConstructor
public class PersonelController {

    private final PersonelService personelServicee;

    @GetMapping("rol-enum")
    public List<EnumRecord> getAllRolEnum() {
        return PersonelRol.personelRolEnumList();
    }

    @GetMapping
    public List<PersonelResponse> getAllPersonel() {
        return personelServicee.getAllPersonel();
    }

    @GetMapping("/{id}")
    public PersonelResponse getPersonelById(@PathVariable Long id) {
        return personelServicee.getPersonelById(id);
    }

    @PostMapping
    public Long savePersonel(@Valid @RequestBody PersonelSaveRequest request) {
        return personelServicee.savePersonel(request);
    }

    @PutMapping
    public Long updatePersonel(@Valid @RequestBody PersonelUpdateRequest request) {

        return personelServicee.updatePersonel(request);
    }

    @DeleteMapping("/{id}")
    public String deletePersonel(@PathVariable Long id) {
        return personelServicee.deletePersonel(id);
    }


}
