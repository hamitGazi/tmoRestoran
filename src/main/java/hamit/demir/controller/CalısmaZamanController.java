package hamit.demir.controller;

import hamit.demir.model.dto.calisZaman.CalismaZamanResponse;
import hamit.demir.model.dto.calisZaman.CalismaZamanSaveRequest;
import hamit.demir.model.dto.calisZaman.CalismaZamanUpdateRequest;
import hamit.demir.model.dto.raporlar.EnumRecord;
import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.service.calismaZaman.CalismaZamanService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/calisma-zamani")
@RequiredArgsConstructor
public class CalısmaZamanController {
    private final CalismaZamanService calismaZamanService;

    @GetMapping("/all")
    public GenericResponse<List<CalismaZamanResponse>> getAllCalismaZamanlari() {
        return GenericResponse.ok(calismaZamanService.getAllCalismaZamanlar());
    }
    @GetMapping("/aktif-ve-istisna")
    public GenericResponse<List<CalismaZamanResponse>> getAktifIstisnaZaman() {
        return GenericResponse.ok(calismaZamanService.getAktifIstisnaZaman());
    }

    @GetMapping("/{id}")
    public GenericResponse<CalismaZamanResponse> getCalismaZamanById(@PathVariable Long id) {
        return GenericResponse.ok(calismaZamanService.getCalismaZamanById(id));
    }

    @PostMapping("/save")
    public GenericResponse<Long> saveCalismaZaman(@Valid @RequestBody CalismaZamanSaveRequest request) {
        return GenericResponse.ok(calismaZamanService.saveCalismaZaman(request));
    }

    @PutMapping("/update")
    public GenericResponse<Long> updateCalismaZaman(@Valid @RequestBody CalismaZamanUpdateRequest request) {
        return GenericResponse.ok(calismaZamanService.updateCalismaZaman(request));
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<String> deleteCalismaZaman(@PathVariable Long id) {
        return GenericResponse.ok(calismaZamanService.deleteCalismaZamanById(id));
    }

    @GetMapping("/gun-enum")
    public GenericResponse<List<EnumRecord>> getCalisGunEnum() {
        return GenericResponse.ok(CalismaGunEnum.calismaGunEnumList());
    }
}


