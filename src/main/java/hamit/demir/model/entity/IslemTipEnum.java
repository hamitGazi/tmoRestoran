package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.utils.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
@Getter
@AllArgsConstructor
public enum IslemTipEnum {
    GIRIS("Giriş"),
    CIKIS("Çıkış"),
    DUZELTME("Düzeltme"),
    TRANSFER("Transfer"),
    FIRE("Fire");
    private final String label;

    public static GenericResponse<List<EnumRecord>> islemTipEnumList() {
        List<EnumRecord> list = Arrays.stream(IslemTipEnum.values())
                .map(deger -> new EnumRecord(deger.name(), deger.getLabel()))
                .toList();
        return GenericResponse.ok(list);

    }
}