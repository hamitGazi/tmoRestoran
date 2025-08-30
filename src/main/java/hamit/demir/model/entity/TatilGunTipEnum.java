package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
@Getter
@AllArgsConstructor
public enum TatilGunTipEnum {
    RESMI("Resmi Tatil"),
    MANUEL("Manuel Tatil"),
    OZEL("Özel Etkinlik"),
    TADILAT("Tadilat Kapanışı");

    private final String label;

    public static List<EnumRecord> tatilTuruEnumList() {
        return Arrays.stream(TatilGunTipEnum.values())
                .map(deger -> new EnumRecord(deger.name(), deger.getLabel()))
                .toList();
    }
}
