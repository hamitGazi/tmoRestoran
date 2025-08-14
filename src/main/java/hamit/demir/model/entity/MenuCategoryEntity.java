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
@Table(name="menu_kategoriler",schema = "alakart")
public class MenuCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Kategori adı.
     */
    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "aciklama",columnDefinition="TEXT")
    private String aciklama;
    /*Sıralama: sira alanı, menüde kategorilerin hangi sırayla gösterileceğini kontrol eder*/
    @Column(name = "menu_sira", nullable = false)
    private Integer menuSira;

    @Column(name = "aktif_mi")
    private Boolean aktif ;

    private LocalDateTime olusturmaTarih;


    private LocalDateTime guncelemeTarih;
}