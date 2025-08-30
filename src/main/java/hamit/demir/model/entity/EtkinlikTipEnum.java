package hamit.demir.model.entity;

import hamit.demir.model.dto.raporlar.EnumRecord;
import hamit.demir.utils.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum EtkinlikTipEnum {
    NORMAL(120, "Normal Yemek", "Standart yemek rezervasyonu"),
    DOGUM_GUNU(240, "Doğum Günü Partisi", "Doğum günü kutlamaları için uzun süre"),
    AILE_YEMEGI(180, "Aile Yemeği", "Aile buluşmaları için orta süre"),
    KURUMSAL_ETKINLIK(240, "Kurumsal Etkinlik", "Şirket yemekleri veya toplantılar"),
    OZEL_KUTLAMA(180, "Özel Kutlama", "Nişan, yıldönümü gibi özel etkinlikler");

    private final int varsayilanSure;
    private final String label;
    private final String aciklama;

     public static List<EnumRecord> etkinliKTipEnumList() {
         List<EnumRecord> list = Arrays.stream(EtkinlikTipEnum.values())
                 .map(deger -> new EnumRecord(deger.name(), deger.getLabel()))
                 .toList();
         return list;
     }


}
