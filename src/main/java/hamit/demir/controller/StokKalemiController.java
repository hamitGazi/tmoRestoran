package hamit.demir.controller;


import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.StokKalemi.StokKalemiSaveRequest;
import hamit.demir.model.dto.StokKalemi.StokKalemiUpdateRequest;


import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.entity.Birim;
import hamit.demir.service.stokKalemi.StokKalemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stok-kalemi")
@RequiredArgsConstructor
public class StokKalemiController {

    private final StokKalemService stokKalemService;
    @GetMapping("birim-enum")
    public List<EnumRecord> getAllBirimEnum() {
        return Birim.birimEnumList();
    }

    @GetMapping
    public List<StokKalemiResponse> getAllStokKalemler() {
        return stokKalemService.getAllStokKalemler();
    }

    @GetMapping("/{id}")
    public StokKalemiResponse getStokKalemById(@PathVariable Long id) {
        return stokKalemService.getStokKalemById(id);
    }

    @PostMapping
    public Long saveStokKalem(@Valid @RequestBody StokKalemiSaveRequest request) {
        return stokKalemService.saveStokKalem(request);
    }

    @PutMapping
    public Long updateStokKalem(@Valid @RequestBody StokKalemiUpdateRequest request) {

        return stokKalemService.updateStokKalem(request);
    }




}
