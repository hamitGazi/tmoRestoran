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
@Table(name = "menu_urun_malzemeler", schema = "alakart",uniqueConstraints = @UniqueConstraint(columnNames = {"menu_urun_id", "stok_kalemi_id"}))
public class MenuItemReceteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_urun_id", nullable = false)
    private MenuItemEntity menuUrun;

    @ManyToOne
    @JoinColumn(name = "stok_kalemi_id", nullable = false)
    private StokKalemiEntity stokKalemi;

    @Column(name = "miktar", nullable = false)
    private BigDecimal miktar;

    @Enumerated(EnumType.STRING)
    @Column(name = "birim", nullable = false)
    private Birim birim;

    private LocalDateTime olusturmaTarih;

    private LocalDateTime guncelleTarih;

}
