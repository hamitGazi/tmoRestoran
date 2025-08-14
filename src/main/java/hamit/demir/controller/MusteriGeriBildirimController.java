package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimSaveRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimUpdateRequest;
import hamit.demir.model.entity.GeriBildirimTuruEnum;
import hamit.demir.service.musteriGeriBildirim.MusteriGeriBildirimService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("musteri-bildirim")
@RequiredArgsConstructor
public class MusteriGeriBildirimController {

    private final MusteriGeriBildirimService musteriGeriBildirimService;

    @GetMapping("all")
        public GenericResponse<List<MusteriGeriBildirimResponse>> getAllMusteriGeriBildirimler() {

        List<MusteriGeriBildirimResponse> allMusteriGeriBildirimler = musteriGeriBildirimService.getAllMusteriGeriBildirimler();
        return GenericResponse.ok(allMusteriGeriBildirimler);

    }

    @GetMapping("/{id}")
    public GenericResponse<MusteriGeriBildirimResponse> getMusteriGeriBildirimById(@PathVariable Long id) {

        MusteriGeriBildirimResponse musteriGeriBildirimResponse = musteriGeriBildirimService.getMusteriGeriBildirimById(id);
        return GenericResponse.ok(musteriGeriBildirimResponse);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveMusteriGeriBildirim(@Valid @RequestBody MusteriGeriBildirimSaveRequest request) {

        Long id = musteriGeriBildirimService.saveMusteriGeriBildirim(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateMusteriGeriBildirim(@Valid @RequestBody MusteriGeriBildirimUpdateRequest request) {

        Long id = musteriGeriBildirimService.updateMusteriGeriBildirim(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteMusteriGeriBildirim(@PathVariable Long id) {

        String str = musteriGeriBildirimService.deleteMusteriGeriBildirim(id);
        return GenericResponse.ok(str);
    }
    @GetMapping("tur-enum")

    public GenericResponse<List<EnumRecord> > getGeriBildirimTurEnum() {
        List<EnumRecord> enumRecords = GeriBildirimTuruEnum.geriBildirimListesi();
        return GenericResponse.ok(enumRecords);

    }

}
