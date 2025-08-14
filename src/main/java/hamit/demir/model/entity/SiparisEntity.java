package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "siparisler",schema = "alakart")
public class SiparisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Siparişin hangi masaya ait olduğu.
     */
    @ManyToOne
    private MasaEntity masa;

    @Column(name = "musteri_adi")
    private String musteriAd;

    @Column(name = "toplam_tutar")
    private BigDecimal toplamTutar;

    @ManyToOne
    @JoinColumn(name = "personel_id")
    private PersonelEntity personel;
    /**
     * Siparişin oluşturulma zamanı.
     */
    private LocalDateTime olusturmaZamani;
    private LocalDateTime guncelleZamani;
    /**
     * Siparişin güncel durumu.
     */
    @Enumerated(EnumType.STRING)
    private SiparisDurumu siparisDurumu;

    /*Sipariş Notu: Genel bir sipariş notu (örneğin, "Hızlı hazırlansın") için bir not alanı eklenebilir.*/
    @Column(name = "siparis_not",columnDefinition="TEXT")
    private String siparisNot;

}