package hamit.demir.model.dto.raporlar.geriBildirim;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record GeriBildirimRaporFilterRequest(
        @NotNull LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        String geriBildirimTuru
) {
}