package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum MasaKonum {
    BAHCE("Bahçe"),
    IC_SALON("İç Salon"),
    TERAS("Teras");

    private final String label;

    public static List<EnumRecord> masaKonumEnumList() {
        return Arrays.stream(Birim.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();
    }

}