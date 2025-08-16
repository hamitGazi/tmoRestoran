package hamit.demir.model.dto.raporlar.stokKalem;

import hamit.demir.model.entity.IslemTipEnum;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record StokKalemRaporResponse(
        Long id,
        String ad,
        BigDecimal miktar,
        BigDecimal kritikMiktar,
        String birim,
        String aciklama,
        IslemTipEnum islemtipi,   // null-safe olmalı
        LocalDateTime islemtarihi
) {}