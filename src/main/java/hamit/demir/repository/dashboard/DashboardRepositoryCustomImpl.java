package hamit.demir.repository.dashboard;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.dashboard.DashboardOzetResponse;
import hamit.demir.model.dto.dashboard.SiparisDurumGrafikResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.math.BigDecimal;
import java.util.List;

public class DashboardRepositoryCustomImpl extends QuerydslRepositorySupport implements DashboardRepositoryCustom {
    public DashboardRepositoryCustomImpl() {
        super(SiparisEntity.class);
    }

    @Override
    public DashboardOzetResponse fetchOzet() {
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;

        Long toplamSiparis = from(siparis)
                .where(siparis.siparisDurumu.ne(SiparisDurumu.IPTAL_EDILDI))
                .select(siparis.id.count())
                .fetchOne();

        BigDecimal toplamGelir = from(siparis)
                .where(siparis.siparisDurumu.eq(SiparisDurumu.TAMAMLANDI))
                .select(siparis.toplamTutar.sumBigDecimal())
                .fetchOne();

        Long aktifMasalar = from(masa)
                .join(siparis).on(siparis.masa.id.eq(masa.id)) // inner join ile sadece siparişi olan masalar
                .where(siparis.siparisDurumu.in(SiparisDurumu.BEKLIYOR, SiparisDurumu.HAZIRLANIYOR, SiparisDurumu.SERVIS_EDILDI))
                .select(masa.id.countDistinct()) // aynı masayı birden fazla siparişten dolayı saymamak için countDistinct
                .fetchOne();

        Long bekleyenRezervasyonlar = from(masa)
                .where(masa.masaDurum.eq(MasaDurumu.REZERVE))
                .select(masa.id.count())
                .fetchOne();

        return new DashboardOzetResponse(
                toplamSiparis != null ? toplamSiparis : 0L,
                toplamGelir != null ? toplamGelir : BigDecimal.ZERO,
                aktifMasalar != null ? aktifMasalar : 0L,
                bekleyenRezervasyonlar != null ? bekleyenRezervasyonlar : 0L
        );
    }

    @Override
    public List<SiparisDurumGrafikResponse> fetchSiparisDurumGrafik() {
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;

        return from(siparis)
                .select(Projections.constructor(SiparisDurumGrafikResponse.class,
                        siparis.siparisDurumu.stringValue(),
                        siparis.id.count()))
                .groupBy(siparis.siparisDurumu)
                .fetch();
    }
}