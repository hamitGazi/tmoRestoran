package hamit.demir.model.dto.personel;

import hamit.demir.model.entity.PersonelRol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonelUpdateRequest(
        @NotNull Long id,
        @NotBlank String ad,
        @NotBlank String soyad,
        @NotNull PersonelRol rol,
        @NotNull Boolean aktif
) {
}
