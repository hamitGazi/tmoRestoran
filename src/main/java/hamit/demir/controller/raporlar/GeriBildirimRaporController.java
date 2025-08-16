package hamit.demir.controller.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.GeriBildirimRaporFilterResponse;
import hamit.demir.service.raporlar.GeriBildirimRaporService;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rapor/geri-bildirim")
@RequiredArgsConstructor
public class GeriBildirimRaporController {

    private final GeriBildirimRaporService geriBildirimRaporService;

    @PostMapping("/all")
    public GenericResponse<List<GeriBildirimRaporFilterResponse>> getAll(@RequestBody GeriBildirimRaporFilterResponse filter) {
        List<GeriBildirimRaporFilterResponse> data = geriBildirimRaporService.getGeriBildirimRaporlari(filter);
        return GenericResponse.ok(data);
    }

    @GetMapping("/geriBildirimTuru-enum")
    public GenericResponse<List<EnumRecord>> getGeriBildirimTurEnum() {
        List<EnumRecord> data = geriBildirimRaporService.getGeriBildirimTurEnum();
        return GenericResponse.ok(data);
    }
}