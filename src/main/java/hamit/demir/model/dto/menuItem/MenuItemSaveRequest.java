package hamit.demir.model.dto.menuItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemSaveRequest(
        @NotBlank String ad,
        String aciklama,
        @NotNull Long kategoriId,
        @NotNull Boolean aktif,
        String resimYolu,
        String ekOzellikler

) {
}
