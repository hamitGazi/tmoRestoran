package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.entity.MasaDurumu;
import hamit.demir.model.entity.MasaKonum;
import hamit.demir.service.MasaService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("masalar")
@RequiredArgsConstructor
public class MasaController {

    private final MasaService masaService;
    @GetMapping("konum-enum")
    public GenericResponse<List<EnumRecord> > getMasaKonumEnum() {
        return MasaKonum.masaKonumEnumList();

    }
    @GetMapping("durum-enum")
    public GenericResponse<List<EnumRecord>> getMasaDurumEnum() {
        return MasaDurumu.masaDurumEnumList();

    }

    @GetMapping("all")
    public GenericResponse< List<MasaResponse>> getAllMasalar() {
        List<MasaResponse> allMasalar = masaService.getAllMasalar();
        return GenericResponse.ok(allMasalar);
    }

    @GetMapping("notRezervasyon")
    public GenericResponse< List<MasaResponse>> getMasaByNotRezervasyon() {
        List<MasaResponse> allMasalar = masaService.getMasaByNotRezervasyon();
        return GenericResponse.ok(allMasalar);
    }
    @GetMapping("/{id}")
    public GenericResponse<MasaResponse> getMasaById(@PathVariable Long id) {
        MasaResponse masaById = masaService.getMasaById(id);
        return GenericResponse.ok(masaById);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveMasa(@Valid @RequestBody MasaSaveRequest request) {

        Long id= masaService.saveMasa(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateMasa(@Valid @RequestBody MasaUpdateRequest request) {

        Long id = masaService.updateMasa(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteMasa(@PathVariable Long id) {
        String str = masaService.deleteMasa(id);
        return GenericResponse.ok(str);
    }
//personel masadurumu  kontrol bekliyor olan masaları güncelliyor.
    @PutMapping("/{id}/durum-guncelle")
    public GenericResponse<String> updateMasaDurumu(@PathVariable Long id, @RequestParam MasaDurumu yeniDurum) {
        masaService.updateMasaDurumu(id, yeniDurum);
        return GenericResponse.ok("Masa durumu güncellendi.");
    }


}
