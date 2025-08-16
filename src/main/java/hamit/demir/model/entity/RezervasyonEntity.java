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

    @Column(name = "musteri_id", nullable = false,columnDefinition = "Text")
    private String musteriAd;

    @Column(name = "masa_id", nullable = false)
    private Long masaId;

    @Column(name = "rezervasyon_zamani", nullable = false)
    private LocalDateTime rezervasyonZamani;

    @Column(name = "kisi_sayisi", nullable = false)
    private Integer kisiSayisi;

    @Enumerated(EnumType.STRING)
    @Column(name = "durum", nullable = false)
    private RezervasyonDurum durum;

    @Column(name = "olusturma_tarih", nullable = false)
    private LocalDateTime olusturmaTarih;

}