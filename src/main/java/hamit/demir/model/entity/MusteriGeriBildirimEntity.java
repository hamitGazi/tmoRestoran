package hamit.demir.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="musteri_geri_bildirim",schema = "alakart")
public class MusteriGeriBildirimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Hangi siparişten sonra alındı.
     */
    private String siparis;
    /**
     * 1–5 arası puan.
     */
    @Min(1)
    @Max(5)
    @Column(name = "puan", nullable = false)
    private Integer puan;
    /**
     * Müşterinin yorum metni.
     */
    @Column(name = "yorum",columnDefinition = "TEXT")
    private String yorum;
    @Column(name = "musteri_adi")
    private String musteriAd;
    @Enumerated(EnumType.STRING)
    private GeriBildirimTuruEnum geriBildirimTur;
    private LocalDateTime olusturmaTarih;
    private LocalDateTime guncelleTarih;

}