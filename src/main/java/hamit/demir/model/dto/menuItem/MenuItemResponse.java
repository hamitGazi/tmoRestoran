package hamit.demir.model.dto.menuItem;

import java.time.LocalDateTime;

public record MenuItemResponse(
        Long id,
        String ad,
        String aciklama,
        Long kategori,
        Boolean aktif,
        String resimYolu,
        String ekOzellikler,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelemeTarih
) {
}
