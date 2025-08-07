package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.entity.MasaDurumu;
import hamit.demir.model.entity.MasaKonum;
import hamit.demir.service.MasaService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("masalar")
@RequiredArgsConstructor
public class MasaController {

    private final MasaService masaService;
    @GetMapping("konum-enum")
    public GenericRespose <List<EnumRecord> >getMasaKonumEnum() {
        return MasaKonum.masaKonumEnumList();

    }
    @GetMapping("durum-enum")
    public GenericRespose<List<EnumRecord>> getMasaDurumEnum() {
        return MasaDurumu.masaDurumEnumList();

    }

    @GetMapping("all")
    public GenericRespose< List<MasaResponse>>getAllMasalar() {
        List<MasaResponse> allMasalar = masaService.getAllMasalar();
        return GenericRespose.ok(allMasalar);
    }

    @GetMapping("/{id}")
    public GenericRespose<MasaResponse> getMasaById(@PathVariable Long id) {
        MasaResponse masaById = masaService.getMasaById(id);
        return GenericRespose.ok(masaById);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveMasa(@Valid @RequestBody MasaSaveRequest request) {

        Long id= masaService.saveMasa(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateMasa(@Valid @RequestBody MasaUpdateRequest request) {

        Long id = masaService.updateMasa(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericRespose<String> deleteMasa(@PathVariable Long id) {
        String str = masaService.deleteMasa(id);
        return GenericRespose.ok(str);
    }


}
