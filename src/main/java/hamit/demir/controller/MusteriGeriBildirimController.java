package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimSaveRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimUpdateRequest;
import hamit.demir.model.entity.GeriBildirimTuruEnum;
import hamit.demir.model.entity.MasaKonum;
import hamit.demir.service.MasaService;
import hamit.demir.service.musteriGeriBildirim.MusteriGeriBildirimService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eclipse.jdt.internal.compiler.env.IGenericField;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("musteri-bildirim")
@RequiredArgsConstructor
public class MusteriGeriBildirimController {

    private final MusteriGeriBildirimService musteriGeriBildirimService;

    @GetMapping("all")
        public GenericRespose<List<MusteriGeriBildirimResponse>> getAllMusteriGeriBildirimler() {

        List<MusteriGeriBildirimResponse> allMusteriGeriBildirimler = musteriGeriBildirimService.getAllMusteriGeriBildirimler();
        return GenericRespose.ok(allMusteriGeriBildirimler);

    }

    @GetMapping("/{id}")
    public GenericRespose<MusteriGeriBildirimResponse> getMusteriGeriBildirimById(@PathVariable Long id) {

        MusteriGeriBildirimResponse musteriGeriBildirimResponse = musteriGeriBildirimService.getMusteriGeriBildirimById(id);
        return GenericRespose.ok(musteriGeriBildirimResponse);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveMusteriGeriBildirim(@Valid @RequestBody MusteriGeriBildirimSaveRequest request) {

        Long id = musteriGeriBildirimService.saveMusteriGeriBildirim(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateMusteriGeriBildirim(@Valid @RequestBody MusteriGeriBildirimUpdateRequest request) {

        Long id = musteriGeriBildirimService.updateMusteriGeriBildirim(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericRespose<String> deleteMusteriGeriBildirim(@PathVariable Long id) {

        String str = musteriGeriBildirimService.deleteMusteriGeriBildirim(id);
        return GenericRespose.ok(str);
    }
    @GetMapping("tur-enum")

    public GenericRespose <List<EnumRecord> >getGeriBildirimTurEnum() {
        List<EnumRecord> enumRecords = GeriBildirimTuruEnum.geriBildirimListesi();
        return GenericRespose.ok(enumRecords);

    }

}
