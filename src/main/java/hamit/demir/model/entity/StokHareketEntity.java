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
    @Table(name = "stok_hareketleri", schema = "alakart")
    public class StokHareketEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "stok_kalemi_id", nullable = false)
        private StokKalemiEntity stokKalemi;

        @Column(name = "islem_tipi", nullable = false)
        @Enumerated(EnumType.STRING)
        private IslemTipEnum islemTipi; // Örneğin: GIRIS, CIKIS

        @Column(name = "miktar", nullable = false)
        private BigDecimal miktar; // İşlem miktarı (eklenen veya çıkan)

        @Column(name = "onceki_miktar", nullable = false)
        private BigDecimal oncekiMiktar; // İşlem öncesi stok miktarı

        @Column(name = "sonraki_miktar", nullable = false)
        private BigDecimal sonrakiMiktar; // İşlem sonrası stok miktarı

        @Column(name = "islem_tarihi", nullable = false)
        private LocalDateTime islemTarihi;

        @ManyToOne
        @JoinColumn(name = "siparis_id")
        private SiparisEntity siparis; // Hangi siparişle ilgili (opsiyonel)

        @Column(name = "aciklama")
        private String aciklama; // Ek bilgi (örneğin, "Sipariş #100 için stok düşüşü")

}
