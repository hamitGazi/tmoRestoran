package hamit.demir.model.dto.StokKalemi;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.Birim;
import hamit.demir.model.entity.IslemTipEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record StokKalemiUpdateRequest(

        @NotNull Long id,
        @NotBlank String ad,
        @NotNull BigDecimal miktar,
        @NotNull Birim birim,
        @NotNull Boolean aktif,
        BigDecimal kritikMiktar,
        @JsonProperty("islemTip") IslemTipEnum islemTip,
        String aciklama // Opsiyonel, hareket için açıklama
) {
}
