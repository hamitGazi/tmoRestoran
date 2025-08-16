package hamit.demir.model.dto.raporlar.masaKullanim;

import hamit.demir.model.entity.MasaKonum;

import java.time.LocalDateTime;

public record MasaKulanimRaporFilterResponse(
        Long id,
        MasaKonum masaKonum,
        Integer gecenSure,       // guncelleZamani - olusturmaZamani farkı
        Integer siparisSayisi,
        LocalDateTime olusturmaZamani
) {}