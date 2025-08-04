package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "siparisler",schema = "alakart")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Siparişin hangi masaya ait olduğu.
     */
    @ManyToOne
    private Masa masa;

    @Column(name = "musteri_adi")
    private String musteriAdi;

    @Column(name = "toplam_tutar")
    private Double toplamTutar;

    @ManyToOne
    @JoinColumn(name = "personel_id")
    private Personel personel;
    /**
     * Siparişin oluşturulma zamanı.
     */
    private LocalDateTime olusturmaZamani;

    /**
     * Siparişin güncel durumu.
     */
    @Enumerated(EnumType.STRING)
    private SiparisDurumu durum;

    /*Sipariş Notu: Genel bir sipariş notu (örneğin, "Hızlı hazırlansın") için bir not alanı eklenebilir.*/
    @Column(name = "not",columnDefinition="TEXT")
    private String not;



}