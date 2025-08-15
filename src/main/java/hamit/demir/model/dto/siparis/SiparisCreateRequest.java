package hamit.demir.model.dto.siparis;

import java.util.List;

public record SiparisCreateRequest(
        Long masaId, // Siparişin bağlı olduğu masa
        Long musteriId, // Siparişi alan müşteri (opsiyonel)
        Long personelId, // Siparişi alan personel
        List<SiparisKalemRequest> kalemler // Sipariş kalemleri (menü öğeleri ve adetler)
) { }
