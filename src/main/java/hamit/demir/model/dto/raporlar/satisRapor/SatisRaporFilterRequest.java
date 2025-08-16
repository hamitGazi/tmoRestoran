package hamit.demir.model.dto.raporlar.satisRapor;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SatisRaporFilterRequest(
        @NotNull LocalDateTime gecerlilikBaslangic,
        @NotNull LocalDateTime gecerlilikBitis,
        String odemeTuru
) {}