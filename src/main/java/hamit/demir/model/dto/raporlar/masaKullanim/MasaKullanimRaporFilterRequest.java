package hamit.demir.model.dto.raporlar.masaKullanim;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MasaKullanimRaporFilterRequest(
        @NotNull LocalDateTime gecerlilikBaslangic,
        @NotNull LocalDateTime gecerlilikBitis,
        String masaKonum
) {}