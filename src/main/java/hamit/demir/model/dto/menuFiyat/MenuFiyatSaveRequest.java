package hamit.demir.model.dto.menuFiyat;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MenuFiyatSaveRequest(
        @NotNull Long menuItem,
        @NotNull Double fiyat,
        Double indirimFiyati,
        @NotNull LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        @NotNull Boolean aktif
) {
}
