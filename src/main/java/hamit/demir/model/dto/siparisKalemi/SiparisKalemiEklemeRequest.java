package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

public record SiparisKalemiEklemeRequest(
        @NotNull Long menuItem,
        @NotNull Integer adet,
        String ekOzellikler,
        String kalemNot
) {
}
