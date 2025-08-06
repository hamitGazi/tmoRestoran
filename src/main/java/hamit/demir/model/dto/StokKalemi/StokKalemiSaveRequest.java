package hamit.demir.model.dto.StokKalemi;

import hamit.demir.model.entity.Birim;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StokKalemiSaveRequest (
        @NotBlank String ad,
        @NotNull Integer miktar,
        @NotNull Birim birim,
        @NotNull Boolean aktif

){
}
