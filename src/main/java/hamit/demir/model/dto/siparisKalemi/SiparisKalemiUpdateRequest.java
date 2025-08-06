package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

public record SiparisKalemiUpdateRequest(
        @NotNull Long id,
        @NotNull Integer adet,
        String ekOzellikler,
        String not

) {
}
