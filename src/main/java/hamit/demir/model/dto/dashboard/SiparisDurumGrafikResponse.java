package hamit.demir.model.dto.dashboard;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SiparisDurumGrafikResponse(
        @NotBlank String durum,
        @NotNull Long adet
) {}