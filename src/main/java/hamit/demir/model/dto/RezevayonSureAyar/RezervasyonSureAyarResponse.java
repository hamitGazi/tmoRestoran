package hamit.demir.model.dto.RezevayonSureAyar;

import hamit.demir.model.entity.EtkinlikTipEnum;

public record RezervasyonSureAyarResponse(
        Long id,
        EtkinlikTipEnum etkinlikTip,
        Integer varsayilanSure,
        Integer minSure,
        Integer maxSure,
        Boolean ozelDurumEsnekligi,
        Boolean aktif


) {
}
