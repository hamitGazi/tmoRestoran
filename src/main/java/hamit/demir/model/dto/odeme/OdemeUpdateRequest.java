package hamit.demir.model.dto.odeme;

import hamit.demir.model.entity.OdemeDurumu;
import jakarta.validation.constraints.NotNull;

public record OdemeUpdateRequest(
        @NotNull Long id,
        @NotNull OdemeDurumu durum
) {
}
