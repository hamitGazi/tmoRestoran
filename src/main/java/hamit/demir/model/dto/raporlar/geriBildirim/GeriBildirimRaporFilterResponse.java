package hamit.demir.model.dto.raporlar.geriBildirim;

import hamit.demir.model.entity.GeriBildirimTuruEnum;

import java.time.LocalDateTime;

public record GeriBildirimRaporFilterResponse(
        Long id,
        LocalDateTime olusturmaTarih,
        GeriBildirimTuruEnum geriBildirimTuru,
        Integer puan,
        String yorum
) {}