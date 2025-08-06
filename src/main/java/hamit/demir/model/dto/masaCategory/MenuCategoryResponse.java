package hamit.demir.model.dto.masaCategory;

import java.time.LocalDateTime;

public record MenuCategoryResponse(

        Long id,
        String ad,
        String aciklama,
        Integer menuSira,
        Boolean aktif,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelemeTarih
) {
}
