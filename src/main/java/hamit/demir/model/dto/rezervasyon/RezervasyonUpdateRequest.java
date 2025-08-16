package hamit.demir.model.dto.rezervasyon;

import hamit.demir.model.entity.RezervasyonDurum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RezervasyonUpdateRequest(
        @NotNull Long id,
        @NotNull String musteriAd,
        @NotNull Long masaId,
        @NotNull LocalDateTime rezervasyonZamani,
        @NotNull @Min(1) Integer kisiSayisi,
        @NotNull RezervasyonDurum durum
) {
}