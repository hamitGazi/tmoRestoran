package hamit.demir.model.dto.menuFiyat;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuFiyatSaveRequest(
        @NotNull Long menuItem,
        @NotNull BigDecimal fiyat,
        @NotNull LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        Boolean aktif
) {
}
