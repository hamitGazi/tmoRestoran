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
@Table(name = "stok_kalemleri",schema = "alakart")
public class StokKalemiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Malzemenin adı (örnek: "Kıyma", "Yoğurt").
     */
    @Column(name = "ad", nullable = false)
    private String ad;

    /**
     * Mevcut miktar.
     */
    @Column(name = "miktar", nullable = false)
    private BigDecimal miktar;

    @Column(name = "kritik-miktar", nullable = false)
    private BigDecimal kritikMiktar;

    /**
     * Birim (örnek: KG, ADET, LITRE).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "birim", nullable = false)
    private Birim birim;
    @Column(name="aciklama",columnDefinition = "TEXT")
    private String aciklama;
    private Boolean aktif;


    private LocalDateTime olusturmaTarih;


    private LocalDateTime guncelleTarih;
}