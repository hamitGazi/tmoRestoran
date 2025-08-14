package hamit.demir.model.dto.odeme;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.OdemeYontem;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OdemeSaveRequest(
        @NotNull Long id,
        @NotNull Long siparis,
        @NotNull BigDecimal toplamTutar,
        @NotNull @JsonProperty("odemeYontem") OdemeYontem odemeYontem,
        @NotNull @JsonProperty("odemeDurum") OdemeDurumu odemeDurum,
        @NotNull LocalDateTime odemeZaman
        ) {
}
