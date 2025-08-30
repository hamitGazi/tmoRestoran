package hamit.demir.model.dto.tatilGun;

import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.model.entity.TatilGunTipEnum;

import java.time.LocalDate;

public record TatilGunResponse(
        LocalDate tarih,
        TatilGunTipEnum tatilTip,
        Long calismaZamanId,
        CalismaGunEnum calismaZamanGun,
        String aciklama,
        Boolean aktif
) {
}
