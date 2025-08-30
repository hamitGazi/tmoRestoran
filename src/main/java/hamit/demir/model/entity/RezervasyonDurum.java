package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.utils.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum RezervasyonDurum {
    ONAYLANDI("Onaylandı"),
    IPTAL("İptal Edildi"),
    BEKLEMEDE("Beklemede"),
    TAMAMLANDI("Tamamlandı"),
    SURESI_DOLDU("Süresi Doldu");


    private final String label;

    public static GenericResponse<List<EnumRecord>> rezervasyonDurumEnumList() {
        List<EnumRecord> list = Arrays.stream(RezervasyonDurum.values())
                .map(deger -> new EnumRecord(deger.name(), deger.getLabel()))
                .toList();
        return GenericResponse.ok(list);
    }
}