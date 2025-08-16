package hamit.demir.controller.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterRequest;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterResponse;
import hamit.demir.model.entity.PersonelRol;
import hamit.demir.service.raporlar.PersonelRaporService;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rapor/personel")
@RequiredArgsConstructor
public class PersonelRaporController {

    private final PersonelRaporService personelRaporService;

    @PostMapping("/all")
    public GenericResponse<List<PersonelRaporFilterResponse>> getAll(@RequestBody PersonelRaporFilterRequest filter) {
        List<PersonelRaporFilterResponse> data = personelRaporService.getPersonelRaporlari(filter);
        return GenericResponse.ok(data);
    }

    @GetMapping("/rol-enum")
    public GenericResponse<List<EnumRecord>> getAllRolEnum() {

        List<EnumRecord> enumRecords = PersonelRol.personelRolEnumList();
        return GenericResponse.ok(enumRecords);
    }
}