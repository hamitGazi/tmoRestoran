package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.siparis.SiparisResponse;
import hamit.demir.model.dto.siparis.SiparisSaveRequest;
import hamit.demir.model.dto.siparis.SiparisUpdateRequest;
import hamit.demir.model.entity.SiparisDurumu;
import hamit.demir.service.siparis.SiparisService;
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
    public List<EnumRecord> getAllDurumEnum() {
        return SiparisDurumu.siprisDurumEnumList();
    }

    @GetMapping
    public List<SiparisResponse> getAllSiparisler() {
        return siparisService.getAllSiparisler();
    }

    @GetMapping("/{id}")
    public SiparisResponse getSiparis(@PathVariable Long id) {
        return siparisService.getSiparisById(id);
    }

    @PostMapping
    public Long saveSiparis(@Valid @RequestBody SiparisSaveRequest request) {
        return siparisService.saveSiparis(request);
    }

    @PutMapping
    public Long updateSiparis(@Valid @RequestBody SiparisUpdateRequest request) {
        return siparisService.updateSiparis(request);
    }

    @DeleteMapping("/{id}")
    public String deleteSiparis(@PathVariable Long id) {
        return siparisService.deleteSiparis(id);
    }

}
