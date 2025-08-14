package hamit.demir.model.dto.siparis;

import hamit.demir.model.dto.masa.MasaIdKodResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.SiparisDurumu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SiparisAllResponse(
        Long id,
        MasaIdKodResponse masa,
        String musteriAd,
        BigDecimal toplamTutar,
        ProjeIdAdRecord personel,
        LocalDateTime olusturmaZamani,
        SiparisDurumu siparisDurumu,
        String siprisNot

) {
}
