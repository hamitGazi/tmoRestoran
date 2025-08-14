package hamit.demir.model.dto.personel;

import hamit.demir.model.entity.PersonelRol;

import java.time.LocalDateTime;

public record PersonelAllResponse(
        Long id,
        String ad,
        String soyad,
        String email,
        PersonelRol rol,
        Boolean aktif,
        LocalDateTime olusturTarih,
        LocalDateTime guncelleTarih

) {
}
