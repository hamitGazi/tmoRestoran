package hamit.demir.model.dto.menuItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemByCategoryIdResponse (
        Long id,
        String ad,
        String aciklama,
        BigDecimal birimFiyat,
        ProjeIdAdRecord kategori,
        Boolean aktif,
        String resimYolu,
        String ekOzellikler,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelemeTarih


){
}
