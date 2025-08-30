package hamit.demir.model.entity;

import hamit.demir.model.dto.raporlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum CalismaGunEnum {
    PAZARTESI("Pazartesi"),
    SALI("Salı"),
    CARSAMBA("Çarşamba"),
    PERSEMBE("Perşembe"),
    CUMA("Cuma"),
    CUMARTESI("Cumartesi"),
    PAZAR("Pazar");

    private final String label;

    public static List<EnumRecord> calismaGunEnumList() {
        List<EnumRecord> list = Arrays.stream(CalismaGunEnum.values())
                .map(deger -> new EnumRecord(deger.name(), deger.getLabel()))
                .toList();
        return list;
    }


    public static CalismaGunEnum fromLocalDate(LocalDate date) {
        return switch (date.getDayOfWeek()) {
            case MONDAY -> PAZARTESI;
            case TUESDAY -> SALI;
            case WEDNESDAY -> CARSAMBA;
            case THURSDAY -> PERSEMBE;
            case FRIDAY -> CUMA;
            case SATURDAY -> CUMARTESI;
            case SUNDAY -> PAZAR;
        };
    }
}
