package hamit.demir.model.dto.musteriGeriBildirim;

import hamit.demir.model.entity.GeriBildirimTuruEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MusteriGeriBildirimUpdateRequest(
        @NotNull Long id,
        String siparis,
        @Min(1) @Max(5) int puan,
        String yorum,
        String musteriAd,
        GeriBildirimTuruEnum geriBildirimtur
) {
}
