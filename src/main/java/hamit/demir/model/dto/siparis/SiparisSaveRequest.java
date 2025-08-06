package hamit.demir.model.dto.siparis;

import jakarta.validation.constraints.NotNull;

public record SiparisSaveRequest(
        @NotNull Long masaId,
        String musteriAd,
        @NotNull Long personelId,
        String not
) {
}
