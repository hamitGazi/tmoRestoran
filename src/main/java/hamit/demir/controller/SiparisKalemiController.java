package hamit.demir.controller;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiUpdateRequest;
import hamit.demir.service.sipariKalemi.SiparisKalemiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("siparis-kalemi")
@RequiredArgsConstructor
public class SiparisKalemiController {

    private final SiparisKalemiService siparisKalemiService;

    @GetMapping
    public List<SiparisKalemiResponse> getAllSiparisKalemler() {
        return siparisKalemiService.getAllSiparisKalemler();
    }

    @GetMapping("/{id}")
    public SiparisKalemiResponse getSiparisKalemi(@PathVariable Long id) {
        return siparisKalemiService.getSiparisKalemiById(id);
    }

    @PostMapping
    public Long saveSiparisKalemi(@Valid @RequestBody SiparisKalemiSaveRequest request) {
        return siparisKalemiService.saveSiparisKalemi(request);
    }

    @PutMapping
    public Long updateSiparisKalemi(@Valid @RequestBody SiparisKalemiUpdateRequest request) {
        return siparisKalemiService.updateSiparisKalemi(request);
    }

    @DeleteMapping("/{id}")
    public String deleteSiparisKalemi(@PathVariable Long id) {
        return siparisKalemiService.deleteSiparisKalemi(id);
    }
}
