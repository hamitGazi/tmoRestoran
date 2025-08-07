package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.siparis.SiparisResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import hamit.demir.model.entity.SiparisDurumu;
import hamit.demir.service.siparis.SiparisService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("siparis")
@RequiredArgsConstructor
public class SiparisController {

    private final SiparisService siparisService;
    @GetMapping("durum-enum")
    public GenericRespose<List<EnumRecord>> getAllDurumEnum() {

        List<EnumRecord> enumRecords = SiparisDurumu.siprisDurumEnumList();
        return GenericRespose.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericRespose<List<SiparisResponse>> getAllSiparisler() {
        List<SiparisResponse> allSiparisler = siparisService.getAllSiparisler();
        return GenericRespose.ok(allSiparisler);
    }
    @GetMapping("/{id}")
    public SiparisResponse getSiparis(@PathVariable Long id) {
        return siparisService.getSiparisById(id);
    }
    @PostMapping("save")
    public GenericRespose<Long> saveSiparis(@Valid @RequestBody SiparisSaveRequest request) {
        Long id = siparisService.saveSiparis(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateSiparis(@Valid @RequestBody SiparisUpdateRequest request) {

        Long id = siparisService.updateSiparis(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSiparis(@PathVariable Long id) {
        return siparisService.deleteSiparis(id);
    }

}
