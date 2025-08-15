package hamit.demir.model.dto.menuFiyat;

import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuFiyatResponse(
        Long id,
        BigDecimal fiyat,
        LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        Boolean aktif,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih
) {
}
