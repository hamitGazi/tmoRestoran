package hamit.demir.model.dto.siparisKalemi;

public record SiparisKalemiResponse(
        Long id,
        Long siparisId,
        Long menuItemId,
        String menuItemAd,
        Integer adet,
        Double birimFiyat,
        Double toplamFiyat,
        String ekOzellikler,
        String not
) {
}
