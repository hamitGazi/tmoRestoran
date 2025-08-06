package hamit.demir.model.dto.siparis;

import hamit.demir.model.entity.SiparisDurumu;
import jakarta.validation.constraints.NotNull;

public record SiparisUpdateRequest(
        @NotNull Long id,
        @NotNull SiparisDurumu durum,
        String not

) {
}
