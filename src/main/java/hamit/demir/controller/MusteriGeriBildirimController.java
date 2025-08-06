package hamit.demir.controller;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimSaveRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimUpdateRequest;
import hamit.demir.service.MasaService;
import hamit.demir.service.musteriGeriBildirim.MusteriGeriBildirimService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musteri-bildirim")
@RequiredArgsConstructor
public class MusteriGeriBildirimController {

    private final MusteriGeriBildirimService musteriGeriBildirimService;

    @GetMapping
    public List<MusteriGeriBildirimResponse> getAllMusteriGeriBildirimler() {
        return musteriGeriBildirimService.getAllMusteriGeriBildirimler();
    }

    @GetMapping("/{id}")
    public MusteriGeriBildirimResponse getMusteriGeriBildirimById(@PathVariable Long id) {
        return musteriGeriBildirimService.getMusteriGeriBildirimById(id);
    }

    @PostMapping
    public Long saveMusteriGeriBildirim(@Valid @RequestBody MusteriGeriBildirimSaveRequest request) {
        return musteriGeriBildirimService.saveMusteriGeriBildirim(request);
    }

    @PutMapping
    public Long updateMusteriGeriBildirim(@Valid @RequestBody MusteriGeriBildirimUpdateRequest request) {

        return musteriGeriBildirimService.updateMusteriGeriBildirim(request);
    }

    @DeleteMapping("/{id}")
    public String deleteMusteriGeriBildirim(@PathVariable Long id) {
        return musteriGeriBildirimService.deleteMusteriGeriBildirim(id);
    }


}
