package hamit.demir.repository.odeme;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaIdKodResponse;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.siparis.SiparisOdemeResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;
import java.util.List;

public class OdemeRepositoryCustomImpl extends QuerydslRepositorySupport implements OdemeRepositoryCustom {
    public OdemeRepositoryCustomImpl() {
        super(OdemeEntity.class);
    }
    LocalDateTime startOfYesterday = LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
    LocalDateTime endOfToday = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);

    public List<OdemeResponse> fetchAllOdemeler() {
        QOdemeEntity root = QOdemeEntity.odemeEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;

        return from(root)
                .leftJoin(root.siparis, siparis)
                .leftJoin(siparis.masa, masa)
                .select(Projections.constructor(OdemeResponse.class,
                        root.id,
                        Projections.constructor(SiparisOdemeResponse.class,
                                siparis.id,
                                siparis.toplamTutar,
                                siparis.olusturmaZamani,
                                siparis.siparisDurumu),
                        Projections.constructor(MasaIdKodResponse.class,
                                masa.id,
                                masa.qrKodUrl),
                        root.toplamTutar,
                        root.yontemi,
                        root.odemeZamani,
                        root.odemeDurum))
        /*        .where(siparis.olusturmaZamani.goe(startOfYesterday).and(siparis.olusturmaZamani.loe(endOfToday)))*/
                .fetch();
    }
    @Override
    public OdemeResponse fetchOdemeById(Long id) {
        QOdemeEntity root = QOdemeEntity.odemeEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;

        return from(root).leftJoin(root.siparis,siparis).leftJoin(siparis.masa,masa).select(Projections.constructor(OdemeResponse.class,
               root.id,
                Projections.constructor(SiparisOdemeResponse.class,
                        siparis.id,
                        siparis.toplamTutar,
                        siparis.olusturmaZamani,
                        siparis.siparisDurumu),
                Projections.constructor(MasaIdKodResponse.class,
                        masa.id,
                        masa.qrKodUrl),
                root.toplamTutar,
                root.yontemi,
                root.odemeZamani,
                root.odemeDurum
        )).where(root.id.eq(id)).fetchOne();
    }

    @Override
    public OdemeEntity fethOdemeBYSiparisId(Long id) {

        QOdemeEntity root = QOdemeEntity.odemeEntity;
        return from(root).select(Projections.constructor(OdemeEntity.class,
                        root.id,
                root.siparis,
                root.toplamTutar,
                root.yontemi,
                root.odemeZamani,
                root.odemeDurum
                ))
                .where(root.siparis.id.eq(id)).fetchOne();


    }

}
