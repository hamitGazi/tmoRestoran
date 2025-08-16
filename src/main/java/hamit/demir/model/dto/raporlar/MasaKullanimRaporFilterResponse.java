package hamit.demir.model.dto.raporlar;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MasaKullanimRaporFilterResponse(
        @NotNull LocalDateTime gecerlilikBaslangic,
        @NotNull LocalDateTime gecerlilikBitis,
        String masaKonum
) {}