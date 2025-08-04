package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "stok_kalemleri")
public class StokKalemi {

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
    private Integer miktar;

    /**
     * Birim (örnek: KG, ADET, LITRE).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "birim", nullable = false)
    private Birim birim;
    /**
     * Aktif mi? (stokta kullanılabilir mi).
     */
    private Boolean aktif;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime olusturmaTarih;

    @Column(name = "updated_at")
    private LocalDateTime guncelleTarih;
}