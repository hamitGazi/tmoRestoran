package hamit.demir.model.dto.tatilGun;


import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.TatilGunTipEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TatilGunSaveRequest(
        @NotNull LocalDate tarih,
        @NotNull @JsonProperty("tatilTip") TatilGunTipEnum tatilTip,
        String aciklama,
        Boolean aktif
) {
}