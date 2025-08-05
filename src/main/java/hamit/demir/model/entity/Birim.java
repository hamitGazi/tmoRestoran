package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum Birim {

    KG("Kilogram"),
    ADET("Adet"),
    LITRE("Litre"),
    METRE("Metre"),
    PAKET("Paket");

    private final String label;

    public static List<EnumRecord> birimEnumList() {
        return Arrays.stream(Birim.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();
    }


}
