package hamit.demir.controller;

import hamit.demir.model.dto.musteri.MusteriResponse;
import hamit.demir.model.dto.musteri.MusteriSaveRequest;
import hamit.demir.model.dto.musteri.MusteriUpdateRequest;
import hamit.demir.service.musteri.MusteriService;
import hamit.demir.utils.GenericRespose;
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
    public GenericRespose<List<MusteriResponse>> getAllMusteriler() {
        List<MusteriResponse> allMusterler = musteriService.getAllMusterler();
        return GenericRespose.ok(allMusterler);
    }

    @GetMapping("/{id}")
    public GenericRespose<MusteriResponse> getMusteriById(@PathVariable Long id) {
        MusteriResponse musteriById = musteriService.getMusteriById(id);
        return GenericRespose.ok(musteriById);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveMusteri(@Valid @RequestBody MusteriSaveRequest request) {
        Long id = musteriService.saveMusteri(request);
        return GenericRespose.ok(id);


    }

    @PutMapping("update")
    public GenericRespose<Long> updateMusteri(@Valid @RequestBody MusteriUpdateRequest request) {
        Long id = musteriService.updateMusteri(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericRespose<String> deleteMusteri(@PathVariable Long id) {

        String str = musteriService.deleteMusteri(id);
        return GenericRespose.ok(str);

    }


}
