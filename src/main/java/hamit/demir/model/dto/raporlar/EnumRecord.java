package hamit.demir.model.dto.raporlar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EnumRecord(
        @NotBlank String name,
        @NotBlank String label
) {}