package hamit.demir.model.dto.StokKalemi;

import hamit.demir.model.entity.Birim;

import java.math.BigDecimal;

public record StokMenuItemReceteResponse (
        Long id,
        String ad,
        BigDecimal miktar,
        Birim birim
)
{
}
