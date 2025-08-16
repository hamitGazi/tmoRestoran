package hamit.demir.model.dto.raporlar.stokKalem;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record StokRaporFilterRequest(
        @NotNull LocalDateTime gecerlilikBaslangic,
        @NotNull LocalDateTime gecerlilikBitis,
        String islemTipi
) {}