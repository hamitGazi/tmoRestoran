package hamit.demir.model.dto.siparis;

import hamit.demir.model.entity.SiparisDurumu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SiparisOdemeResponse(
        Long id,
        BigDecimal toplamTutar,
        LocalDateTime olustumaZaman,
        SiparisDurumu siparisDurum

) {
}
