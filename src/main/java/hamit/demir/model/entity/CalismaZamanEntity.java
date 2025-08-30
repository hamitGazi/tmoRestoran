package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calisma_zamani", schema = "alakart")
public class CalismaZamanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gun", nullable = false)
    private CalismaGunEnum gun;

    @Column(name = "acilis_saati", nullable = false)
    private LocalTime acilisSaat;

    @Column(name = "kapanis_saati", nullable = false)
    private LocalTime kapanisSaat;
    @Column(name="bitis_tarih")
    private LocalDate bitisTarih;
    @Column(name = "tatil", nullable = false)
    private Boolean tatil;

    @Column(name = "istisna", nullable = false)
    private Boolean istisna;

    @Column(name = "aktif", nullable = false)
    private Boolean aktif;

    @Column(name = "aciklama")
    private String aciklama;
}
