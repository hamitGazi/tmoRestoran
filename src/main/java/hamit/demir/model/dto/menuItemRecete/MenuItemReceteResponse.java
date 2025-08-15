package hamit.demir.model.dto.menuItemRecete;

import hamit.demir.model.dto.StokKalemi.StokMenuItemReceteResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.Birim;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemReceteResponse(
        Long id,
        ProjeIdAdRecord menuItemId,
        StokMenuItemReceteResponse stokKalemId,
        BigDecimal miktar,
        Birim birim,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih

) {
}
