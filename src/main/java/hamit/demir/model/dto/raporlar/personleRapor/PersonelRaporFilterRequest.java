package hamit.demir.model.dto.raporlar.personleRapor;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PersonelRaporFilterRequest(
        @NotNull LocalDateTime gecerlilikBaslangic,
        @NotNull LocalDateTime gecerlilikBitis,
        String rol
) {}