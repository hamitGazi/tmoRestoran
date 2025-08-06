package hamit.demir.model.dto.siparis;

import hamit.demir.model.entity.SiparisDurumu;

import java.time.LocalDateTime;

public record SiparisResponse(
        Long id,
        Long masaId,
        String masaKod,
        String musteriAd,
        Double toplamTutar,
        Long personelId,
        String personelAdSoyad,
        LocalDateTime olusturmaZamani,
        SiparisDurumu siparisDurumu,
        String not

) {
}
