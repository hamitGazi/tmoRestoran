package hamit.demir.model.dto.musteriGeriBildirim;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MusteriGeriBildirimUpdateRequest(
        @NotNull Long id,
        @Min(1) @Max(5) int puan,
        @NotBlank String yorum

) {
}
