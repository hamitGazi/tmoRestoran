package hamit.demir.model.dto.calisZaman;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.model.entity.EtkinlikTipEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CalismaZamanSaveRequest(
        @NotNull @JsonProperty("gun") CalismaGunEnum gun,
        @NotNull LocalTime acilisSaati,
        @NotNull LocalTime kapanisSaati,
        Boolean tatil,
        LocalDate bitisTarihi,
        @JsonProperty("ozelEtkinlikTip") EtkinlikTipEnum ozelEtkinlikTip,
        Boolean istisna,
        Boolean aktif,
        String aciklama
) {
}