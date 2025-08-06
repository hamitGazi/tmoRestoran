package hamit.demir.model.dto.musteri;

import java.time.LocalDateTime;

public record MusteriResponse (
        Long id,
        String ad,
        String soyad,
        String telefon,
        String email,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelleTarih

){
}
