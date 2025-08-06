package hamit.demir.model.dto.masa;

import hamit.demir.model.entity.MasaKonum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MasaSaveRequest (
    @NotBlank String qrKodUrl,
    @NotNull Integer kapasite,
    @NotNull MasaKonum masaKonum
)
{
}
