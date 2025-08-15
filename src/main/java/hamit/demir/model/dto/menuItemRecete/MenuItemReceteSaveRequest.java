package hamit.demir.model.dto.menuItemRecete;

import hamit.demir.model.entity.Birim;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record MenuItemReceteSaveRequest(
        Long menuUrunId,
        Long stokKalemiId,
        BigDecimal miktar,
        Birim birim


){
}
