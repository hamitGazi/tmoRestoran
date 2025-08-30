package hamit.demir.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rezervasyon_sure_ayar",schema="alakart")
public class RezervasyonSureAyarEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="etkinlik_tip", nullable=false,unique = true)
    private EtkinlikTipEnum etkinlikTip;
    @Column(name="varsayilan_sure",nullable=false)
    private Integer varsayilanSure;
    @Column(name="min_sure", nullable=false)
    private Integer minSure;
    @Column(name="max_sure", nullable=false)
    private Integer maxSure;
    /** Özel durumlar için kapasite esnetme izni (örneğin, çocuk/engelli). */
    @Column(name="ozel_durum_esnekligi")
    private Boolean ozelDurumEsnekligi;
    @Column(name="aktif",nullable = false)
    private Boolean aktif;


}
