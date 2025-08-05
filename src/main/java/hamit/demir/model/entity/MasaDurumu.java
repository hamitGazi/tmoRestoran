package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum MasaDurumu {
    AKTIF("Aktif"),
    REZERVE("Rezerve"),
    KAPALI("Kapalı");

    private final String label;

    public static List<EnumRecord> masaDurumEnumList() {
        return Arrays.stream(Birim.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();
    }

}