package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

public record SiparisKalemiSaveRequest(
        @NotNull Long siparisId,
        @NotNull Long menuItemId,
        @NotNull Integer adet,
        String ekOzellikler,
        String not

) {
}
