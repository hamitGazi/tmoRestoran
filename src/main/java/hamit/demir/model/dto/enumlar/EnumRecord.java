package hamit.demir.model.dto.enumlar;

import hamit.demir.model.entity.PersonelRol;

public record EnumRecord <T extends Enum<T>>(
        String name,
        String label

) {
}
