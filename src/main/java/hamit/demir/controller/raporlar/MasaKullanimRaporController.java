package hamit.demir.controller.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKulanimRaporFilterResponse;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKullanimRaporFilterRequest;
import hamit.demir.model.entity.MasaDurumu;
import hamit.demir.service.raporlar.MasaKullanimRaporService;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rapor/masa-kullanim")
@RequiredArgsConstructor
public class MasaKullanimRaporController {

    private final MasaKullanimRaporService masaKullanimRaporService;

    @PostMapping("/all")
    public GenericResponse<List<MasaKulanimRaporFilterResponse>> getAll(@RequestBody MasaKullanimRaporFilterRequest filter) {
        List<MasaKulanimRaporFilterResponse> data = masaKullanimRaporService.getMasaKullanimRaporlari(filter);
        return GenericResponse.ok(data);
    }



    @GetMapping("/masaKonum-enum")
    public GenericResponse<List<EnumRecord>> getMasaDurumEnum() {
        return MasaDurumu.masaDurumEnumList();
    }
}