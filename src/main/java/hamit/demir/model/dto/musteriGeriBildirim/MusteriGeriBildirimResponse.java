package hamit.demir.model.dto.musteriGeriBildirim;

import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.GeriBildirimTuruEnum;

import java.time.LocalDateTime;

public record MusteriGeriBildirimResponse(
        Long id,
        ProjeIdAdRecord siparis,
        Integer puan,
        String yorum,
        String musteriAd,
        GeriBildirimTuruEnum geriBildirimTur,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih

) {
}
