package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum OdemeDurumu {
    BASARILI("Başarılı"),
    BEKLIYOR("Bekliyor"),
    IPTAL_EDILDI("İptal Edildi");
    private final String label;

    public static List<EnumRecord> odemeDurumEnumList() {
        return Arrays.stream(OdemeDurumu.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();
    }


}
