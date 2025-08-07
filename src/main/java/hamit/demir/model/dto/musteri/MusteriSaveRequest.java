package hamit.demir.model.dto.musteri;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MusteriSaveRequest(

        @NotBlank String ad,
        @NotBlank String soyad,
        String telefon,
        String email,
        String adres
/*        @Size(min = 6) @NotBlank String sifre*/
) {
}
