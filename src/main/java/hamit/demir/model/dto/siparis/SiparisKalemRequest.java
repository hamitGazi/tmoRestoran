package hamit.demir.model.dto.siparis;

public record SiparisKalemRequest(
        Long menuUrunId, // Menü öğesinin ID'si
        Integer adet // Sipariş edilen adet
)   { }
