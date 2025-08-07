package hamit.demir.controller;


import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.StokKalemi.StokKalemiSaveRequest;
import hamit.demir.model.dto.StokKalemi.StokKalemiUpdateRequest;


import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.entity.Birim;
import hamit.demir.service.stokKalemi.StokKalemService;
import hamit.demir.utils.GenericRespose;
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
    public GenericRespose<List<EnumRecord>> getAllBirimEnum() {
        List<EnumRecord> enumRecords = Birim.birimEnumList();
        return GenericRespose.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericRespose<List<StokKalemiResponse>> getAllStokKalemler() {

        List<StokKalemiResponse> allStokKalemler = stokKalemService.getAllStokKalemler();
        return GenericRespose.ok(allStokKalemler);
    }

    @GetMapping("/{id}")
    public GenericRespose<StokKalemiResponse> getStokKalemById(@PathVariable Long id) {

        StokKalemiResponse stokKalemById = stokKalemService.getStokKalemById(id);
        return GenericRespose.ok(stokKalemById);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveStokKalem(@Valid @RequestBody StokKalemiSaveRequest request) {
        Long id = stokKalemService.saveStokKalem(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateStokKalem(@Valid @RequestBody StokKalemiUpdateRequest request) {

        Long id = stokKalemService.updateStokKalem(request);
        return GenericRespose.ok(id);
    }




}
