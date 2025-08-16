package hamit.demir.model.dto.rezervasyon;

import hamit.demir.model.entity.RezervasyonDurum;

import java.time.LocalDateTime;

public record RezervasyonResponse(
        Long id,
        String musteriAd,
        Long masaId,
        String masaQrKodUrl,
        LocalDateTime rezervasyonZamani,
        Integer kisiSayisi,
        RezervasyonDurum durum,
        LocalDateTime olusturmaTarih
) {
}