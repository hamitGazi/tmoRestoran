package hamit.demir.controller;

import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarResponse;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarSaveRequest;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarUpdateRequest;
import hamit.demir.model.dto.raporlar.EnumRecord;
import hamit.demir.model.dto.rezervasyon.RezervasyonSaveRequest;
import hamit.demir.model.entity.EtkinlikTipEnum;
import hamit.demir.model.entity.RezervasyonSureAyarEntity;
import hamit.demir.repository.rezervasyonSureAyar.RezervasyonSureAyarRepository;
import hamit.demir.service.RezervasyonSureAyar.RezervasyonSureAyarService;
import hamit.demir.utils.GenericResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("rezervayon-sure-ayar")
@RequiredArgsConstructor
public class RezervasyonSureAyarController {

    private final RezervasyonSureAyarService rezervasyonSureAyarService;

    @GetMapping("rezervasyon-etkinliktip-enum")
    public GenericResponse<List<EnumRecord>> getAllEtkinlikTipEnum() {
        List<EnumRecord> enumRecords= EtkinlikTipEnum.etkinliKTipEnumList();
        return GenericResponse.ok(enumRecords);
    }


    @GetMapping("all")
    public GenericResponse<List<RezervasyonSureAyarResponse>> getAllRezervasyonSureAyar() {
        return GenericResponse.ok( rezervasyonSureAyarService.getAllRezervasyonSureAyarlar());
    }
    @GetMapping("/{id}")
    public GenericResponse<RezervasyonSureAyarResponse> getRezervasyonSureAyarById(@PathVariable Long id) {

        return GenericResponse.ok(rezervasyonSureAyarService.getRezervasyonSureAyarById(id));
    }

    @PostMapping("/save")
    public GenericResponse<Long> saveRezervasyonSureAyar(@Valid @RequestBody RezervasyonSureAyarSaveRequest request) {
        return  GenericResponse.ok(rezervasyonSureAyarService.saveRezervasyonSureAyar(request));

    }

    @PutMapping("/update")
    public GenericResponse<Long> updateRezervasyonSureAyar(@Valid @RequestBody RezervasyonSureAyarUpdateRequest request) {

        return GenericResponse.ok(rezervasyonSureAyarService.updateRezervasyonSureAyar(request));
    }

    @DeleteMapping("/delete")
    public GenericResponse<String> deleteRezervasyonSureAyar(@RequestParam Long id) {

        return  GenericResponse.ok(rezervasyonSureAyarService.deleteRezervayonSureAyar(id));
    }

    @GetMapping("/sure-duzenle")
    public GenericResponse<Set<Integer>> getSureAyarListEtkinlikTipById(@RequestParam EtkinlikTipEnum etkinlikTip) {
        return GenericResponse.ok(rezervasyonSureAyarService.getSureAyarListEtkinlikTipById(etkinlikTip));

    }





}
