package hamit.demir.model.dto.StokKalemi;

import hamit.demir.model.entity.Birim;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record StokKalemiResponse(
        Long id,
        String ad,
        BigDecimal miktar,
        BigDecimal kritikMiktar,
        Birim birim,
        String aciklama,
        Boolean aktif,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih

) {
}