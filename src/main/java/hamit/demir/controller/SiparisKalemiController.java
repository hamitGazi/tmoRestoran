package hamit.demir.controller;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import hamit.demir.repository.siparisKalemi.SiparisKalemRepository;
import hamit.demir.service.sipariKalemi.SiparisKalemiService;
import hamit.demir.service.stokKalemi.StokKalemService;
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
    private final SiparisKalemRepository siparisKalemRepository;
    private final StokKalemService stokKalemService;

    @GetMapping("all")
    public GenericResponse<List<SiparisKalemiResponse>> getAllSiparisKalemler() {

        List<SiparisKalemiResponse> allSiparisKalemler = siparisKalemiService.getAllSiparisKalemler();
        return GenericResponse.ok(allSiparisKalemler);
    }

    @GetMapping("masa/{id}")
    public GenericResponse<List<SiparisKalemiResponse>> getKalemlerByMasaId(@PathVariable Long id) {
        List<SiparisKalemiResponse> siparisKalem = siparisKalemiService.getKalemlerByMasaId(id);
        return GenericResponse.ok(siparisKalem);
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
    @DeleteMapping("/delete/{id}")
    public GenericResponse<String> deleteSiparisKalem(@PathVariable Long id) {
        String s = siparisKalemiService.deleteSiparisKalem(id);
        return GenericResponse.ok(s);
    }

}




