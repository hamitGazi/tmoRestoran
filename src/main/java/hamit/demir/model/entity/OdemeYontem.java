package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum OdemeYontem {
    NAKIT("Nakit"),
    KREDI_KARTI("Kredi Kartı"),
    ONLINE("Online Ödeme"),
    SECILMEDI("Seçilmedi");
    private final String label;
    public static List<EnumRecord> oedmeYontemEnumList() {
        return Arrays.stream(OdemeYontem.values()).map(deger-> new EnumRecord(deger.name(),deger.getLabel())).toList();
    }

}