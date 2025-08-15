package hamit.demir.model.dto.siparis;

import hamit.demir.model.dto.masa.MasaIdKodResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.dto.personel.PersonelIdAdResponse;
import hamit.demir.model.entity.SiparisDurumu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SiparisResponse(
        Long id,
         MasaIdKodResponse masa,
        String musteriAd,
        BigDecimal toplamTutar,
         PersonelIdAdResponse personel,
        LocalDateTime olusturmaZamani,
        SiparisDurumu siparisDurumu,
        String siprisNot

) {
}
