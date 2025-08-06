package hamit.demir.model.dto.menuItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemUpdateRequest(

        @NotNull Long id,
        @NotBlank String ad,
        String aciklama,
        @NotNull Long kategoriId,
        @NotNull Boolean aktif,
        String resimYolu,
        String ekOzellikler
) {
}
