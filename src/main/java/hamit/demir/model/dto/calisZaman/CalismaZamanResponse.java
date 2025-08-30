package hamit.demir.model.dto.calisZaman;

import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.model.entity.EtkinlikTipEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public record CalismaZamanResponse(
        Long id,
        CalismaGunEnum gun,
        LocalTime acilisSaati,
        LocalTime kapanisSaati,
        Boolean tatil,
        LocalDate bitisTarihi,
        EtkinlikTipEnum ozelEtkinlikTip,
        Boolean istisna,
        Boolean aktif,
        String aciklama
) {
}