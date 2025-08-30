package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "rezervasyon", schema = "alakart")
@Entity
@Getter
@Setter
public class RezervasyonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "musteri_Ad", nullable = false, columnDefinition = "Text")
    private String musteriAd;

    @Column(name = "masa_id", nullable = false)
    private Long masaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "etkinlik_tip", nullable = false)
    private EtkinlikTipEnum etkinlikTip;

    @Column(name = "rezervasyon_zamani", nullable = false)
    private LocalDateTime rezervasyonZamani;

    @Column(name = "rezervasyon_suresi")
    private Integer rezervasyonSuresi;

    @Column(name = "kisi_sayisi", nullable = false)
    private Integer kisiSayisi;

    /*@Transient
    public LocalDateTime getBitisZamani() {
        if (rezervasyonZamani == null || rezervasyonSuresi == null) {
            return null;
        }
        return rezervasyonZamani.plusMinutes(rezervasyonSuresi);
    }*/
    @Enumerated(EnumType.STRING)
    @Column(name = "durum", nullable = false)
    private RezervasyonDurum durum;

    @Column(name = "olusturma_tarih", nullable = false)
    private LocalDateTime olusturmaTarih;

    @Column(name="aciklama",columnDefinition = "text")
    private String aciklama;

}