package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.utils.GenericRespose;
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

    public static GenericRespose< List<EnumRecord>> masaKonumEnumList() {
        List<EnumRecord> list = Arrays.stream(MasaKonum.values()).map(deger -> new EnumRecord(deger.name(), deger.getLabel())).toList();

    return GenericRespose.ok(list);}

}