package hamit.demir.controller;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import hamit.demir.service.sipariKalemi.SiparisKalemiService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("siparis-kalem")
@RequiredArgsConstructor
public class SiparisKalemiController {

    private final SiparisKalemiService siparisKalemiService;

    @GetMapping("all")
    public GenericResponse<List<SiparisKalemiResponse>> getAllSiparisKalemler() {

        List<SiparisKalemiResponse> allSiparisKalemler = siparisKalemiService.getAllSiparisKalemler();
        return GenericResponse.ok(allSiparisKalemler);
    }

    @GetMapping("/{id}")
    public GenericResponse<SiparisKalemiResponse> getSiparisKalemiById(@PathVariable Long id) {

        SiparisKalemiResponse siparisKalemiById = siparisKalemiService.getSiparisKalemiById(id);
        return GenericResponse.ok(siparisKalemiById);
    }
    @GetMapping("by-siparis/{id}")
    public GenericResponse<List<SiparisKalemiResponse>> getKalemlerBySiparisId(@PathVariable Long id) {

        List<SiparisKalemiResponse> siparisKalemler = siparisKalemiService.getKalemlerBySiparisId(id);
        return GenericResponse.ok(siparisKalemler);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveSiparisKalemi(@Valid @RequestBody SiparisKalemiSaveRequest request) {
        Long id = siparisKalemiService.saveSiparisKalemi(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateSiparisKalemi(@Valid @RequestBody SiparisKalemiUpdateRequest request) {
        Long id = siparisKalemiService.updateSiparisKalemi(request);
        return GenericResponse.ok(id);
    }


    @DeleteMapping("delete/{id}")
    public GenericResponse<String> deleteSiparisKalemi(@PathVariable Long id) {
        String str = siparisKalemiService.deleteSiparisKalemi(id);
        return GenericResponse.ok(str);
    }
}

