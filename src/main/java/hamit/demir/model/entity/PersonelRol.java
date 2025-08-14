package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum PersonelRol {
    GARSON("Garson"),
    MUTFAK("Mutfak Personeli"),
    YONETICI("Yönetici"),
    KASA("Kasa Sorumlusu");

    private final String label;

    public static List<EnumRecord> personelRolEnumList() {
        return Arrays.stream(PersonelRol.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();
    }

}