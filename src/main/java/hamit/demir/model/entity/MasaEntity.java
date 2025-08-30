package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "masalar", schema = "alakart", indexes = {@Index(name = "idx_masa_kod", columnList = "qr_kod_url")})
public class MasaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * QR kod ile eşleşen masa kodu (örnek: "A1").
     */
    @Column(name = "qr_kod_url", nullable = false, unique = true)
    private String qrKodUrl;

    /**
     * Masanın kaç kişilik olduğu.
     */
    @Column(name = "kapasite", nullable = false)
    private Integer kapasite;

    @Enumerated(EnumType.STRING)
    @Column(name = "masa_konum", nullable = false)
    private MasaKonum  masaKonum;
    /**
     * Masa şu anda dolu mu (müşteri oturuyor mu).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "masa_durum")
    private MasaDurumu masaDurum;

    private LocalDateTime olusturmaTarih;

    private LocalDateTime guncelemeTarih;
}

