package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.odeme.OdemeSaveRequest;
import hamit.demir.model.dto.odeme.OdemeUpdateRequest;
import hamit.demir.model.entity.OdemeYontem;
import hamit.demir.service.odeme.OdemeService;
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
    public List<EnumRecord> getYontemEnum() {
        return OdemeYontem.oedmeYontemEnumList();
    }


    @GetMapping
    public List<OdemeResponse> getAllOdemeler() {
        return odemeService.getAllOdemeler();
    }

    @GetMapping("/{id}")
    public OdemeResponse getOdemeById(@PathVariable Long id) {
        return odemeService.getOdemeById(id);
    }

    @PostMapping
    public Long saveOdeme(@Valid @RequestBody OdemeSaveRequest request) {
        return odemeService.saveOdeme(request);
    }

    @PutMapping
    public Long updateOdeme(@Valid @RequestBody OdemeUpdateRequest request) {

        return odemeService.updateOdeme(request);
    }



}
