package hamit.demir.model.entity;

import hamit.demir.model.dto.enumlar.EnumRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor

public enum GeriBildirimTuruEnum {

    SIKAYET("Şikayet"),
    TESEKKUR("Teşekkür"),
    BILGILENDIRME("Bilgilendirme"),
    ONERI("Öneri"),
    SORU("Soru");

    private final String label;

    public static List<EnumRecord> geriBildirimListesi() {
        return Arrays.stream(hamit.demir.model.entity.GeriBildirimTuruEnum.values())
                .map(tur -> new EnumRecord(tur.name(), tur.getLabel()))
                .toList();
    }
}