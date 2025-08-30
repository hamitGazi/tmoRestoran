package hamit.demir.model.dto.RezevayonSureAyar;

import com.fasterxml.jackson.annotation.JsonProperty;
import hamit.demir.model.entity.EtkinlikTipEnum;

public record RezervasyonSureAyarSaveRequest(

        @JsonProperty("etkinlikTip") EtkinlikTipEnum etkinlikTip,
        Integer varsayilanSure,
        Integer minSure,
        Integer maxSure,
        Boolean ozelDurumEsnekligi,
        Boolean aktif


) {
}
