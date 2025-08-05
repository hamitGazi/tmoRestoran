package hamit.demir.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="musteri_geri_bildirimi",schema = "alakart")
public class MusteriGeriBildirimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Hangi siparişten sonra alındı.
     */
    @ManyToOne
    private SiparisEntity siparis;
    /**
     * 1–5 arası puan.
     */
    @Min(1)
    @Max(5)
    @Column(name = "puan", nullable = false)
    private int puan;
    /**
     * Müşterinin yorum metni.
     */
    @Column(name = "yorum",columnDefinition = "TEXT",nullable = false)
    private String yorum;
    @Column(name = "musteri_adi")
    private String musteriAdi;

    private LocalDateTime olusturmaTarih;

    private LocalDateTime guncelleTarih;

}