package hamit.demir.model.dto.menuItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuItemSaveRequest(
        @NotBlank String ad,
        @NotNull Long kategoriId,
        Boolean aktif,
        String resimYolu,
        String aciklama,
        String ekOzellikler

) {
}
