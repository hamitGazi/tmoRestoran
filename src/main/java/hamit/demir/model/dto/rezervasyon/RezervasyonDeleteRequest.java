package hamit.demir.model.dto.rezervasyon;

import hamit.demir.model.entity.RezervasyonDurum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RezervasyonDeleteRequest(
        @NotNull Long id,
        @NotNull Long masaId

) {
}