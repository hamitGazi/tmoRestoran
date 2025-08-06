package hamit.demir.model.dto.menuFiyat;

import java.time.LocalDateTime;

public record MenuFiyatResponse(
        Long id,
        Long menuItemId,
        Double fiyat,
        Double indirimFiyati,
        LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        Boolean aktif,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih
) {
}
