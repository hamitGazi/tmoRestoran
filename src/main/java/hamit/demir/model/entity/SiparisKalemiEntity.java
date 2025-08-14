package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private BigDecimal birimFiyat;

    @Column(name = "toplam_fiyat", nullable = false)
    private BigDecimal toplamFiyat;

    /*Ek Özellikler: Ürün için seçilen ek özellikler (örneğin, "Ekstra sos") için bir ekOzellikler alanı veya tablosu eklenebilir.*/
    @Column(name = "ek_ozellikler")
    private String ekOzellikler;
    /**
     * Müşteri notu (örnek: "Soğansız olsun").
     */
    @Column(name = "kalem_not")
    private String kalemNot;
}