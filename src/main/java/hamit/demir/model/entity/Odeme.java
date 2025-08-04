package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="odemeler",schema = "alakart")
public class Odeme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Ödeme hangi sipariş için yapıldı.
     */

    @OneToOne
    private Siparis siparis;
    /**
     * Ödenen toplam tutar.
     */
    @Column(name="tutar")
    private Double tutar;

    /**
     * Ödeme yöntemi.
     */

    @Enumerated(EnumType.STRING)
    private OdemeYontemi yontemi;
    /**
     * Ödeme zamanı.
     */

    @Column(name = "odemeZamani", nullable = false)
    private LocalDateTime odemeZamani;

    @Enumerated(EnumType.STRING)
    @Column(name = "durum", nullable = false)
    private OdemeDurumu durum;

}