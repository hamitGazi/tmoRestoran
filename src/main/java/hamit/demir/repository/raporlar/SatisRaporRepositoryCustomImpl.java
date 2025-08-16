package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterRequest;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterResponse;
import hamit.demir.model.entity.OdemeYontem;
import hamit.demir.model.entity.QOdemeEntity;
import hamit.demir.model.entity.QSiparisEntity;
import hamit.demir.model.entity.SiparisEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class SatisRaporRepositoryCustomImpl extends QuerydslRepositorySupport implements SatisRaporRepositoryCustom {
    public SatisRaporRepositoryCustomImpl() {
        super(SiparisEntity.class);
    }

    @Override
    public List<SatisRaporFilterResponse> fetchSatisRaporlari(SatisRaporFilterRequest filter) {
        QSiparisEntity root = QSiparisEntity.siparisEntity;
        QOdemeEntity odeme = QOdemeEntity.odemeEntity;

        var query = from(root)
                .leftJoin(root.odeme, odeme)
                .select(Projections.constructor(SatisRaporFilterResponse.class,
                        root.id,
                        root.olusturmaZamani,
                         odeme.yontemi,//odemeYontem

                        root.toplamTutar,
                        root.id.count().intValue()
                ))
                .groupBy(root.olusturmaZamani, odeme.yontemi);

        if (filter.gecerlilikBaslangic() != null) {
            query.where(root.olusturmaZamani.goe(filter.gecerlilikBaslangic()));
        }
        if (filter.gecerlilikBitis() != null) {
            query.where(root.olusturmaZamani.loe(filter.gecerlilikBitis()));
        }
        if (filter.odemeTuru() != null) {
            query.where(odeme.yontemi.eq(OdemeYontem.valueOf(filter.odemeTuru())));
        }

        return query.fetch();
    }
}
