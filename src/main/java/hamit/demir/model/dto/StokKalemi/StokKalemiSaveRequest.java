package hamit.demir.model.dto.StokKalemi;

import hamit.demir.model.entity.Birim;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record StokKalemiSaveRequest (
        @NotBlank String ad,
        @NotNull BigDecimal miktar,
        @NotNull Birim birim,
        @NotNull Boolean aktif


){
}
