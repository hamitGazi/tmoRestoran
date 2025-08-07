package hamit.demir.model.dto.menuFiyat;

import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;

import java.time.LocalDateTime;

public record MenuFiyatResponse(
        Long id,
        ProjeIdAdRecord menuItem,
        Double fiyat,
        Double indirimFiyati,
        LocalDateTime gecerlilikBaslangic,
        LocalDateTime gecerlilikBitis,
        Boolean aktif,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih
) {
}
