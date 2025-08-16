package hamit.demir.controller.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterRequest;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterResponse;
import hamit.demir.model.entity.OdemeYontem;
import hamit.demir.service.raporlar.SatisRaporService;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rapor/satis")
@RequiredArgsConstructor
public class SatisRaporController {

    private final SatisRaporService satisRaporService;

    @PostMapping("/all")
    public GenericResponse<List<SatisRaporFilterResponse>> getAll(@RequestBody SatisRaporFilterRequest filter) {
        List<SatisRaporFilterResponse> data = satisRaporService.getSatisRaporlari(filter);
        return GenericResponse.ok(data);
    }

    @GetMapping("/yontemOdeme-enum")
    public GenericResponse<List<EnumRecord>> getYontemEnum() {

        List<EnumRecord> enumRecords = OdemeYontem.oedmeYontemEnumList();
        return GenericResponse.ok(enumRecords);
    }

}