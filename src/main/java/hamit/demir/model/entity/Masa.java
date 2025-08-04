package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "masalar", indexes = {@Index(name = "idx_masa_kod", columnList = "kod")})
public class Masa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * QR kod ile eşleşen masa kodu (örnek: "A1").
     */
    @Column(name = "Qr_kod_url", nullable = false, unique = true)
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
    @Column(name = "durum", nullable = false)
    private MasaDurumu durum;

    private LocalDateTime olusturmaTarih;

    private LocalDateTime guncelemeTarih;
}

