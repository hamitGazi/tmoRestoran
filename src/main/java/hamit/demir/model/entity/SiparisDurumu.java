package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum SiparisDurumu {
    BEKLIYOR("Bekliyor"),
    HAZIRLANIYOR("Hazırlanıyor"),
    SERVIS_EDILDI("Servis Edildi"),
    IPTAL_EDILDI("İptal Edildi"),
    TAMAMLANDI("Tamamlandı");

    private final String label;

    public static List<EnumRecord> siprisDurumEnumList() {
        return Arrays.stream(SiparisDurumu.values()).map(deger-> new EnumRecord(deger.name(),deger.getLabel())).toList();
    }


}
