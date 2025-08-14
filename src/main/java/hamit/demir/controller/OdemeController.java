package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.odeme.OdemeSaveRequest;
import hamit.demir.model.dto.odeme.OdemeUpdateRequest;
import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.OdemeYontem;
import hamit.demir.service.odeme.OdemeService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("odeme")
@RequiredArgsConstructor
public class OdemeController {

    private final OdemeService odemeService;

    @GetMapping("yontemOdeme-enum")
    public GenericResponse<List<EnumRecord>> getYontemEnum() {

        List<EnumRecord> enumRecords = OdemeYontem.oedmeYontemEnumList();
        return GenericResponse.ok(enumRecords);
    }

    @GetMapping("durumOdeme-enum")
    public GenericResponse<List<EnumRecord>> getDurumEnum() {

        List<EnumRecord> enumRecords = OdemeDurumu.odemeDurumEnumList();
        return GenericResponse.ok(enumRecords);
    }


    @GetMapping("all")
    public GenericResponse<List<OdemeResponse>> getAllOdemeler() {

        List<OdemeResponse> allOdemeler = odemeService.getAllOdemeler();
        return GenericResponse.ok(allOdemeler);
    }

    @GetMapping("/{id}")
    public GenericResponse<OdemeResponse> getOdemeById(@PathVariable Long id) {

        OdemeResponse odemeById = odemeService.getOdemeById(id);
        return GenericResponse.ok(odemeById);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveOdeme(@Valid @RequestBody OdemeSaveRequest request) {

        Long id = odemeService.saveOdeme(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateOdeme(@Valid @RequestBody OdemeUpdateRequest request) {

        Long id = odemeService.updateOdeme(request);
        return GenericResponse.ok(id);
    }



}
