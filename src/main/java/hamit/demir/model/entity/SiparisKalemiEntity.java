package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "siparis_kalemleri",schema = "alakart")
public class SiparisKalemiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Hangi siparişe ait olduğu.
     */
    @ManyToOne
    private SiparisEntity siparis;

    /**
     * Sipariş edilen ürün.
     */
    @ManyToOne
    private MenuItemEntity menuItem;

    /**
     * Kaç adet istendiği.
     */
    @Column(name = "adet", nullable = false)
    private Integer adet;

    @Column(name = "birim_fiyat", nullable = false)
    private Double birimFiyat;

    @Column(name = "toplam_fiyat", nullable = false)
    private Double toplamFiyat;

    /*Ek Özellikler: Ürün için seçilen ek özellikler (örneğin, "Ekstra sos") için bir ekOzellikler alanı veya tablosu eklenebilir.*/
    @Column(name = "ek_ozellikler")
    private String ekOzellikler;
    /**
     * Müşteri notu (örnek: "Soğansız olsun").
     */
    private String not;
}