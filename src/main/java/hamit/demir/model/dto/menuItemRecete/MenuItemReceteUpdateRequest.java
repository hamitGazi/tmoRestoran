package hamit.demir.model.dto.menuItemRecete;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.Birim;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record MenuItemReceteUpdateRequest(
         Long id,
        Long menuUrunId,
        Long stokKalemiId,
        BigDecimal miktar,
        @JsonProperty("birim") Birim birim
) {
}
