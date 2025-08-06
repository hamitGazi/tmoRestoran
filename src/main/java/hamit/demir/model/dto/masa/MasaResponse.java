package hamit.demir.model.dto.masa;

import hamit.demir.model.entity.MasaDurumu;
import hamit.demir.model.entity.MasaKonum;

import java.time.LocalDateTime;

public record MasaResponse (
        Long id,
        String qrKodUrl,
        Integer kapasite,
        MasaKonum masaKonum,
        MasaDurumu masaDurum,
        LocalDateTime olusturmaTarih,
        LocalDateTime guncelemeTarih){
}
