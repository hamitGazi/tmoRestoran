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
    public List<MasaResponse> getAllMasalar() {
        return masaService.getAllMasalar();
    }

    @GetMapping("/{id}")
    public MasaResponse getMasaById(@PathVariable Long id) {
        return masaService.getMasaById(id);
    }

    @PostMapping("save")
    public Long saveMasa(@Valid @RequestBody MasaSaveRequest request) {
        return masaService.saveMasa(request);
    }

    @PutMapping("update")
    public Long updateMasa(@Valid @RequestBody MasaUpdateRequest request) {

        return masaService.updateMasa(request);
    }

    @DeleteMapping("/{id}")
    public String deleteMasa(@PathVariable Long id) {
        return masaService.deleteMasa(id);
    }


}
