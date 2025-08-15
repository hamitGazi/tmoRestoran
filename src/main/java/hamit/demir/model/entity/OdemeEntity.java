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
@Table(name="odemeler",schema = "alakart")
public class OdemeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Ödeme hangi sipariş için yapıldı.
     */

    @OneToOne(fetch = FetchType.LAZY)
    private SiparisEntity siparis;
    /**
     * Ödenen toplam tutar.
     */
    @Column(name="tutar")
    private BigDecimal toplamTutar;

    /**
     * Ödeme yöntemi.
     */

    @Enumerated(EnumType.STRING)
    private OdemeYontem yontemi;
    /**
     * Ödeme zamanı.
     */

    @Column(name = "odemeZamani")
    private LocalDateTime odemeZamani;

    @Enumerated(EnumType.STRING)
    @Column(name = "durum", nullable = false)
    private OdemeDurumu odemeDurum;

}