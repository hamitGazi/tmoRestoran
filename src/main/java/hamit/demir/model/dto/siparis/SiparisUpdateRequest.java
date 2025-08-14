package hamit.demir.model.dto.siparis;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.SiparisDurumu;
import jakarta.validation.constraints.NotNull;

public record SiparisUpdateRequest(
        @NotNull Long id,
        Long masa,
        String musteriAd,
        Long personel,
        @JsonProperty("siparisDurumu") SiparisDurumu durum,
        String siparisNot
) {
}
