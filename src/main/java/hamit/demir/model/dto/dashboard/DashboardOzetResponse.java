package hamit.demir.model.dto.dashboard;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DashboardOzetResponse(
        @NotNull Long toplamSiparis,
        @NotNull BigDecimal toplamGelir,
        @NotNull Long aktifMasalar,
        @NotNull Long bekleyenRezervasyonlar
) {}