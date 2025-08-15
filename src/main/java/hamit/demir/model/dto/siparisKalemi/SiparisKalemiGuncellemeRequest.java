package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

public record SiparisKalemiGuncellemeRequest(
        Long id,
        @NotNull Long menuItem,
        @NotNull Integer adet,
        String ekOzellikler,
        String kalemNot
) {
}
