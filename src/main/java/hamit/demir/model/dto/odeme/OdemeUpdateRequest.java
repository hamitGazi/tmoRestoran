package hamit.demir.model.dto.odeme;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.OdemeDurumu;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OdemeUpdateRequest(
        @NotNull Long id,
        @NotNull @JsonProperty("odemeDurum") OdemeDurumu odemeDurum,
        BigDecimal toplamTutar
) {
}
