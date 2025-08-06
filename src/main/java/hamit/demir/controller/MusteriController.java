package hamit.demir.controller;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.musteri.MusteriResponse;
import hamit.demir.model.dto.musteri.MusteriSaveRequest;
import hamit.demir.model.dto.musteri.MusteriUpdateRequest;
import hamit.demir.service.MasaService;
import hamit.demir.service.musteri.MusteriService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musteri")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;

    @GetMapping
    public List<MusteriResponse> getAllMusteriler() {
        return musteriService.getAllMusterler();
    }

    @GetMapping("/{id}")
    public MusteriResponse getMusteriById(@PathVariable Long id) {
        return musteriService.getMusteriById(id);
    }

    @PostMapping
    public Long saveMusteri(@Valid @RequestBody MusteriSaveRequest request) {
        return musteriService.saveMusteri(request);
    }

    @PutMapping
    public Long updateMusteri(@Valid @RequestBody MusteriUpdateRequest request) {

        return musteriService.updateMusteri(request);
    }

    @DeleteMapping("/{id}")
    public String deleteMusteri(@PathVariable Long id) {
        return musteriService.deleteMusteri(id);
    }


}
