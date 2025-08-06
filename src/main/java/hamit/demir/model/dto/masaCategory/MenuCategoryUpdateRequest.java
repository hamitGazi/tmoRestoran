package hamit.demir.model.dto.masaCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuCategoryUpdateRequest(

        @NotNull Long id,
        @NotBlank String ad,
        String aciklama,
        @NotNull Integer menuSira,
        @NotNull Boolean aktif
) {
}
