package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.siparis.SiparisAllResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import hamit.demir.model.entity.SiparisDurumu;
import hamit.demir.service.siparis.SiparisService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("siparis")
@RequiredArgsConstructor
public class SiparisController {

    private final SiparisService siparisService;
    @GetMapping("siparisDurum-enum")
    public GenericResponse<List<EnumRecord>> getAllDurumEnum() {

        List<EnumRecord> enumRecords = SiparisDurumu.siprisDurumEnumList();
        return GenericResponse.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericResponse<List<SiparisAllResponse>> getAllSiparisler() {
        List<SiparisAllResponse> allSiparisler = siparisService.getAllSiparisler();
        return GenericResponse.ok(allSiparisler);
    }
    @GetMapping("/{id}")
    public GenericResponse<SiparisAllResponse> getSiparis(@PathVariable Long id) {

        SiparisAllResponse siparisById = siparisService.getSiparisById(id);
        return GenericResponse.ok(siparisById);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveSiparis(@Valid @RequestBody SiparisSaveRequest request) {
        Long id = siparisService.saveSiparis(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateSiparis(@Valid @RequestBody SiparisUpdateRequest request) {

        Long id = siparisService.updateSiparis(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteSiparis(@PathVariable Long id) {
        return siparisService.deleteSiparis(id);
    }

}


/*
@PostMapping("/musteri/save")
public ResponseEntity<Long> saveMusteriSiparis(@RequestBody SiparisSaveRequest request, Principal principal) {
    String kullaniciAdi = principal.getName(); // JWT'den gelen müşteri adı
    Long siparisId = siparisService.saveSiparis(request, kullaniciAdi);
    return ResponseEntity.ok(siparisId);
}*/
