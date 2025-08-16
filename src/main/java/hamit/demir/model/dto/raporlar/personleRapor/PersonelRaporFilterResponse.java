package hamit.demir.model.dto.raporlar.personleRapor;

import hamit.demir.model.entity.PersonelRol;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PersonelRaporFilterResponse(
        Long id,
        String adSoyad,
        PersonelRol rol,
        Integer siparisSayisi,
        BigDecimal toplamTutar,
        Integer gecenSure
) {}