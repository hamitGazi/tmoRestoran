package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


    @Data
    @Entity
   @Table(name = "menu_fiyatlar",schema="alakart")
    public class MenuFiyatEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /**
         * Fiyatın ait olduğu menü ürünü.
         */
        @ManyToOne(optional = false)
        @JoinColumn(name = "menu_item_id", nullable = false)
        private MenuItemEntity menuItem;

        /**
         * Ürünün fiyatı (örneğin: 59.90).
         */
        @Column(name = "fiyat", nullable = false)
        private Double fiyat;

        /**
         * İndirimli fiyat (varsa, örneğin: 49.90).
         */
        @Column(name = "indirim_fiyati")
        private Double indirimFiyati;

        /**
         * Fiyatın geçerli olduğu başlangıç zamanı.
         */
        @Column(name = "gecerlilik_baslangic", nullable = false)
        private LocalDateTime gecerlilikBaslangic;

        /**
         * Fiyatın geçerli olduğu bitiş zamanı (varsa).
         */
        @Column(name = "gecerlilik_bitis")
        private LocalDateTime gecerlilikBitis;

        /**
         * Fiyatın aktif olup olmadığı (menüde gösterilsin mi).
         */
        @Column(name = "aktif", nullable = false)
        private boolean aktif;


        private LocalDateTime olusturmaTarih;


        private LocalDateTime guncelleTarih;
    }
