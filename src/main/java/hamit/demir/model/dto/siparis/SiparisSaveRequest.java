package hamit.demir.model.dto.siparis;

import hamit.demir.model.dto.siparisKalemi.SiparisKalemiSaveRequest;

import java.util.List;

public record SiparisSaveRequest(
        Long masa,
        String musteriAd,
        Long personel,
        List<SiparisKalemiSaveRequest> menuItems,
        String siparisNot


) {
}

