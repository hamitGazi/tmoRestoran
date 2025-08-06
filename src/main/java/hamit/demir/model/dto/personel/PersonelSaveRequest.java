package hamit.demir.model.dto.personel;

import hamit.demir.model.entity.PersonelRol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PersonelSaveRequest (
        @NotBlank String ad,
        @NotBlank String soyad,
        @Email @NotBlank String email,
        @Size(min = 6) @NotBlank String sifre,
        @NotNull PersonelRol rol,
        @NotNull Boolean aktif


){
}
