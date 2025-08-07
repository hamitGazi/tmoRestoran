package hamit.demir.controller;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import hamit.demir.service.sipariKalemi.SiparisKalemiService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("siparis-kalemi")
@RequiredArgsConstructor
public class SiparisKalemiController {

    private final SiparisKalemiService siparisKalemiService;

    @GetMapping("all")
    public GenericRespose<List<SiparisKalemiResponse>> getAllSiparisKalemler() {

        List<SiparisKalemiResponse> allSiparisKalemler = siparisKalemiService.getAllSiparisKalemler();
        return GenericRespose.ok(allSiparisKalemler);
    }

    @GetMapping("/{id}")
    public GenericRespose<SiparisKalemiResponse> getSiparisKalemi(@PathVariable Long id) {

        SiparisKalemiResponse siparisKalemiById = siparisKalemiService.getSiparisKalemiById(id);
        return GenericRespose.ok(siparisKalemiById);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveSiparisKalemi(@Valid @RequestBody SiparisKalemiSaveRequest request) {
        Long id = siparisKalemiService.saveSiparisKalemi(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateSiparisKalemi(@Valid @RequestBody SiparisKalemiUpdateRequest request) {

        Long id = siparisKalemiService.updateSiparisKalemi(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSiparisKalemi(@PathVariable Long id) {
        return siparisKalemiService.deleteSiparisKalemi(id);
    }
}
