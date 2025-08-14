package hamit.demir.model.dto.odeme;

import hamit.demir.model.dto.masa.MasaIdKodResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.dto.siparis.SiparisOdemeResponse;
import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.OdemeYontem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OdemeResponse (
        Long id,
        SiparisOdemeResponse siparis,
        MasaIdKodResponse masa,
        BigDecimal  toplamTutar,
        OdemeYontem odemeYontem,
        LocalDateTime odemeZaman,
        OdemeDurumu odemeDurum
){
}
