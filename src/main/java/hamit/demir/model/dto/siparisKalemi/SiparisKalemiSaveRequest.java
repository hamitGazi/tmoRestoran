package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

public record SiparisKalemiSaveRequest(
        @NotNull Long siparis,
        @NotNull Long menuItem,
        @NotNull Integer adet,
        String ekOzellikler,
        String not

) {
}
