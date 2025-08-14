package hamit.demir.controller;


import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.StokKalemi.StokKalemiSaveRequest;
import hamit.demir.model.dto.StokKalemi.StokKalemiUpdateRequest;


import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.entity.Birim;
import hamit.demir.service.stokKalemi.StokKalemService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("stok-kalemi")
@RequiredArgsConstructor
public class StokKalemiController {

    private final StokKalemService stokKalemService;
    @GetMapping("birim-enum")
    public GenericResponse<List<EnumRecord>> getAllBirimEnum() {
        List<EnumRecord> enumRecords = Birim.birimEnumList();
         return GenericResponse.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericResponse<List<StokKalemiResponse>> getAllStokKalemler() {

        List<StokKalemiResponse> allStokKalemler = stokKalemService.getAllStokKalemler();
        return GenericResponse.ok(allStokKalemler);
    }

    @GetMapping("/{id}")
    public GenericResponse<StokKalemiResponse> getStokKalemById(@PathVariable Long id) {

        StokKalemiResponse stokKalemById = stokKalemService.getStokKalemById(id);
        return GenericResponse.ok(stokKalemById);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveStokKalem(@Valid @RequestBody StokKalemiSaveRequest request) {
        Long id = stokKalemService.saveStokKalem(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateStokKalem(@Valid @RequestBody StokKalemiUpdateRequest request) {

        Long id = stokKalemService.updateStokKalem(request);
        return GenericResponse.ok(id);
    }




}
