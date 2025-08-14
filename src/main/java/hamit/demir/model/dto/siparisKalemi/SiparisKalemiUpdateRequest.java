package hamit.demir.model.dto.siparisKalemi;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SiparisKalemiUpdateRequest(
        Long id,
        @NotNull Long siparis,
        @NotNull Long menuItem,
        @NotNull Integer adet,
        String ekOzellikler,
        String kalemNot


) {
}
