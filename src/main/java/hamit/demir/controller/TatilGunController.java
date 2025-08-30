package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.tatilGun.TatilGunResponse;
import hamit.demir.model.dto.tatilGun.TatilGunSaveRequest;
import hamit.demir.model.dto.tatilGun.TatilGunUpdateRequest;
import hamit.demir.model.entity.TatilGunTipEnum;
import hamit.demir.service.tatilGun.TatilGunService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tatil-gun")
@RequiredArgsConstructor
public class TatilGunController {
    private final TatilGunService tatilGunService;

    @GetMapping("/all")
    public GenericResponse<List<TatilGunResponse>> getAllTatilGunleri() {
        return GenericResponse.ok(tatilGunService.getAllTatilGunleri());
    }

    @GetMapping("/{id}")
    public GenericResponse<TatilGunResponse> getTatilGunById(@PathVariable Long id) {
        return GenericResponse.ok(tatilGunService.getTatilGunById(id));
    }

    @GetMapping("/by-calisma-zaman/{calismaZamanId}")
    public GenericResponse<List<TatilGunResponse>> getByCalismaZamanId(@PathVariable Long calismaZamanId) {
        return GenericResponse.ok(tatilGunService.getTatilGunByCalismaZamanId(calismaZamanId));
    }

    @PostMapping("/save")
    public GenericResponse<Long> saveTatilGun(@Valid @RequestBody TatilGunSaveRequest request) {
        return GenericResponse.ok(tatilGunService.saveTatilGun(request));
    }

    @PutMapping("/update")
    public GenericResponse<Long> updateTatilGun(@Valid @RequestBody TatilGunUpdateRequest request) {
        return GenericResponse.ok(tatilGunService.updateTatilGun(request));
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<String> deleteTatilGun(@PathVariable Long id) {
        return GenericResponse.ok(tatilGunService.deleteTatilGunById(id));
    }

    @GetMapping("/tatil-turu-enum")
    public GenericResponse<List<EnumRecord>> getTatilTuruEnum() {
        return GenericResponse.ok(TatilGunTipEnum.tatilTuruEnumList());
    }

    @PostMapping("/load-resmi")
    public GenericResponse<String> loadResmiTatiller() {
        return GenericResponse.ok(tatilGunService.loadResmiTatiller());
    }
}