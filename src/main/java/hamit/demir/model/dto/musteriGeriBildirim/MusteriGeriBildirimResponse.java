package hamit.demir.model.dto.musteriGeriBildirim;

import java.time.LocalDateTime;

public record MusteriGeriBildirimResponse(
        Long id,
        Long siparisId,
        Integer puan,
        String yorum,
        String musteriAdi,
        LocalDateTime olusturmaTarih,
        LocalDateTime güncelleTarih

) {
}
