package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "menu_urunler")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Ürünün adı (örneğin: "Lahmacun", "Ayran").
     */
    @Column(name = "ad", nullable = false)
    private String ad;
    /**
     * Ürünün açıklaması (örneğin: "Taş fırında pişmiş").
     */
    @Column(name = "aciklama")
    private String aciklama;
    /**
     * Ürünün ait olduğu menü kategorisi.
     */
    @ManyToOne
    private MenuCategory kategori;

    /**
     * Ürün aktif mi (menüde gösterilsin mi).
     */
    @Column(name = "aktif", nullable = false)
    private boolean aktif;

    /**
     * Ürüne ait görselin URL ya da dosya yolu (örnek: "/images/lahmacun.jpg").
     */
    @Column(name = "resim_yolu")
    private String resimYolu;

    /*Ek Özellikler: Ürün için özel seçenekler (örneğin, "Acısız", "Ekstra Peynir") için bir ekOzellikler alanı veya tablosu eklenebilir.*/
    @Column(name = "ek_ozellikler", columnDefinition = "jsonb")
    private String ekOzellikler;

/*    @Column(name = "indirim_fiyati")
    private Double indirimFiyati;*/

    private LocalDateTime olusturmaTarih;


    private LocalDateTime guncelemeTarih;

}