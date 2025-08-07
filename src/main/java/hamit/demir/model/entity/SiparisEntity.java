package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
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
    private Double toplamTutar;

    @ManyToOne    @JoinColumn(name = "personel_id")
    private PersonelEntity personel;
    /**
     * Siparişin oluşturulma zamanı.
     */
    private LocalDateTime olusturmaZamani;

    /**
     * Siparişin güncel durumu.
     */
    @Enumerated(EnumType.STRING)
    private SiparisDurumu siparisDurumu;

    /*Sipariş Notu: Genel bir sipariş notu (örneğin, "Hızlı hazırlansın") için bir not alanı eklenebilir.*/
    @Column(name = "not",columnDefinition="TEXT")
    private String not;

}