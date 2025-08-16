package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonDeleteRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonSaveRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonUpdateRequest;
import hamit.demir.model.entity.MasaDurumu;
import hamit.demir.model.entity.MasaKonum;
import hamit.demir.model.entity.RezervasyonDurum;
import hamit.demir.service.MasaService;
import hamit.demir.service.rezervasyon.RezervasyonService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rezervasyon")
@RequiredArgsConstructor
public class RezervasyonController {

    private final RezervasyonService rezervasyonService;

    @GetMapping("/all")
    public GenericResponse<List<RezervasyonResponse>> getAllRezervasyonlar() {
        return GenericResponse.ok(rezervasyonService.getAllRezervasyonlar());
    }

    @GetMapping("/{id}")
    public GenericResponse<RezervasyonResponse> getRezervasyonById(@PathVariable Long id) {
        return GenericResponse.ok(rezervasyonService.getRezervasyonById(id));
    }

    @PostMapping("/save")
    public GenericResponse<Long> saveRezervasyon(@Valid @RequestBody RezervasyonSaveRequest request) {
        return GenericResponse.ok(rezervasyonService.saveRezervasyon(request));
    }

    @PutMapping("/update")
    public GenericResponse<Long> updateRezervasyon(@Valid @RequestBody RezervasyonUpdateRequest request) {
        return GenericResponse.ok(rezervasyonService.updateRezervasyon(request));
    }

    @DeleteMapping("/delete")
    public GenericResponse<String> deleteRezervasyon(@RequestBody RezervasyonDeleteRequest request) {
        return GenericResponse.ok(rezervasyonService.deleteRezervasyon(request));
    }

    @GetMapping("/durum-enum")
    public GenericResponse<List<EnumRecord>> getDurumEnum() {
        return RezervasyonDurum.rezervasyonDurumEnumList();
    }
}