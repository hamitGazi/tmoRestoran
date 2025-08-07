package hamit.demir.model.dto.odeme;

import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.OdemeYontem;
import jakarta.validation.constraints.NotNull;

public record OdemeSaveRequest(
        @NotNull Long siparis,
        @NotNull Double tutar,
        @NotNull OdemeYontem yontemi,
        @NotNull OdemeDurumu durum
) {
}
