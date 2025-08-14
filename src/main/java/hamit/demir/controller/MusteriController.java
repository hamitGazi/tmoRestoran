package hamit.demir.controller;

import hamit.demir.model.dto.musteri.MusteriResponse;
import hamit.demir.model.dto.musteri.MusteriSaveRequest;
import hamit.demir.model.dto.musteri.MusteriUpdateRequest;
import hamit.demir.service.musteri.MusteriService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("musteri")
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService musteriService;

    @GetMapping("all")
    public GenericResponse<List<MusteriResponse>> getAllMusteriler() {
        List<MusteriResponse> allMusterler = musteriService.getAllMusterler();
        return GenericResponse.ok(allMusterler);
    }

    @GetMapping("/{id}")
    public GenericResponse<MusteriResponse> getMusteriById(@PathVariable Long id) {
        MusteriResponse musteriById = musteriService.getMusteriById(id);
        return GenericResponse.ok(musteriById);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveMusteri(@Valid @RequestBody MusteriSaveRequest request) {
        Long id = musteriService.saveMusteri(request);
        return GenericResponse.ok(id);


    }

    @PutMapping("update")
    public GenericResponse<Long> updateMusteri(@Valid @RequestBody MusteriUpdateRequest request) {
        Long id = musteriService.updateMusteri(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteMusteri(@PathVariable Long id) {

        String str = musteriService.deleteMusteri(id);
        return GenericResponse.ok(str);

    }


}
