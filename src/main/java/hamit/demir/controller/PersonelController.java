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
import hamit.demir.utils.GenericRespose;
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
    public GenericRespose<List<EnumRecord>> getAllRolEnum() {

        List<EnumRecord> enumRecords = PersonelRol.personelRolEnumList();
        return GenericRespose.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericRespose<List<PersonelResponse>> getAllPersonel() {
        List<PersonelResponse> allPersonel = personelServicee.getAllPersonel();
        return GenericRespose.ok(allPersonel);
    }

    @GetMapping("/{id}")
    public PersonelResponse getPersonelById(@PathVariable Long id) {
        return personelServicee.getPersonelById(id);
    }

    @PostMapping("save")
    public  GenericRespose<Long> savePersonel(@Valid @RequestBody PersonelSaveRequest request) {

        Long id = personelServicee.savePersonel(request);
        return GenericRespose.ok(id);
    }

    @PutMapping
    public GenericRespose<Long> updatePersonel(@Valid @RequestBody PersonelUpdateRequest request) {

        Long id = personelServicee.updatePersonel(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public String deletePersonel(@PathVariable Long id) {
        return personelServicee.deletePersonel(id);
    }


}
