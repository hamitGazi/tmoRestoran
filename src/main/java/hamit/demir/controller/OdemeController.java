package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.odeme.OdemeSaveRequest;
import hamit.demir.model.dto.odeme.OdemeUpdateRequest;
import hamit.demir.model.entity.OdemeYontem;
import hamit.demir.service.odeme.OdemeService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odeme")
@RequiredArgsConstructor
public class OdemeController {

    private final OdemeService odemeService;

    @GetMapping("yontem-enum")
    public GenericRespose<List<EnumRecord>> getYontemEnum() {

        List<EnumRecord> enumRecords = OdemeYontem.oedmeYontemEnumList();
        return GenericRespose.ok(enumRecords);
    }


    @GetMapping("all")
    public GenericRespose<List<OdemeResponse>> getAllOdemeler() {

        List<OdemeResponse> allOdemeler = odemeService.getAllOdemeler();
        return GenericRespose.ok(allOdemeler);
    }

    @GetMapping("/{id}")
    public GenericRespose<OdemeResponse> getOdemeById(@PathVariable Long id) {

        OdemeResponse odemeById = odemeService.getOdemeById(id);
        return GenericRespose.ok(odemeById);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveOdeme(@Valid @RequestBody OdemeSaveRequest request) {

        Long id = odemeService.saveOdeme(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateOdeme(@Valid @RequestBody OdemeUpdateRequest request) {

        Long id = odemeService.updateOdeme(request);
        return GenericRespose.ok(id);
    }



}
