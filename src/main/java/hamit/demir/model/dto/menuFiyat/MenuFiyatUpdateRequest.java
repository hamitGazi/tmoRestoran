package hamit.demir.model.dto.menuFiyat;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuFiyatUpdateRequest(

        @NotNull Long id,
        @NotNull BigDecimal fiyat,
        @NotNull LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        @NotNull Boolean aktif
) {
}
