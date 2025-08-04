package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="menu_kategoriler")
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Kategori adı.
     */
    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "aciklama")
    private String aciklama;
    /*Sıralama: sira alanı, menüde kategorilerin hangi sırayla gösterileceğini kontrol eder*/
    @Column(name = "sira")
    private Integer sira;

    @Column(name = "aktif", nullable = false)
    private boolean aktif = true;

    private LocalDateTime olusturmaTarih;


    private LocalDateTime guncelemeTarih;
}