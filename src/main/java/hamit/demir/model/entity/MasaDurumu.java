package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.utils.GenericResponse;
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

    public static GenericResponse<List<EnumRecord>> masaDurumEnumList() {
        List<EnumRecord> list = Arrays.stream(MasaDurumu.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();
   return GenericResponse.ok(list);
    }

}