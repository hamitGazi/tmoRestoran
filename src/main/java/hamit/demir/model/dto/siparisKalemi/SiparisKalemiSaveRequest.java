package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

public record SiparisKalemiSaveRequest(
                 Long siparis,
        @NotNull Long menuItem,
        @NotNull Integer adet,
        String ekOzellikler,
        String kalemNot
) {
}
