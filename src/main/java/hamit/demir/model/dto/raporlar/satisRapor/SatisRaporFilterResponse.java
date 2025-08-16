package hamit.demir.model.dto.raporlar.satisRapor;

import hamit.demir.model.entity.OdemeYontem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SatisRaporFilterResponse(
        Long id,
        LocalDateTime olusturmaZamani,
        OdemeYontem odemeYontemi,
        BigDecimal toplamTutar,
        Integer satisAdedi
) {}