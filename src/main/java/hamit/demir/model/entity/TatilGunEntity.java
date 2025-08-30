package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tatil_gun", schema = "alakart")
public class TatilGunEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tarih", nullable = false)
    private LocalDate tarih;

    @Enumerated(EnumType.STRING)
    @Column(name = "tatil_turu")
    private TatilGunTipEnum tatilTip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calisma_zaman_id")
    private CalismaZamanEntity calismaZaman;

    @Column(name = "aciklama")
    private String aciklama;

    @Column(name = "aktif")
    private Boolean aktif = true;
}
