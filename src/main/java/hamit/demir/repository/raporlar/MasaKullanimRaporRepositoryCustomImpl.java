package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.MasaKullanimRaporFilterResponse;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MasaKonum;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QSiparisEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MasaKullanimRaporRepositoryCustomImpl extends QuerydslRepositorySupport implements MasaKullanimRaporRepositoryCustom {
    public MasaKullanimRaporRepositoryCustomImpl() {
        super(MasaEntity.class);
    }


    @Override
    public List<MasaKullanimRaporFilterResponse> fetchMasaKullanimRaporlari(MasaKullanimRaporFilterResponse filter) {
        QMasaEntity root = QMasaEntity.masaEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;

        var query = from(root)
                .leftJoin(siparis).on(siparis.masa.id.eq(root.id))
                .select(Projections.constructor(MasaKullanimRaporFilterResponse.class,
                        root.id,
                        new EnumRecord(root.masaKonum.name(), root.masaKonum.getLabel()),
                        siparis.guncelleZamani.subtract(siparis.olusturmaZamani).castToNum(Integer.class),
                        siparis.id.count().intValue(),
                        siparis.olusturmaZamani.asString()
                ))
                .groupBy(root.id);

        if (filter.gecerlilikBaslangic() != null) {
            query.where(siparis.olusturmaZamani.goe(filter.gecerlilikBaslangic()));
        }
        if (filter.gecerlilikBitis() != null) {
            query.where(siparis.olusturmaZamani.loe(filter.gecerlilikBitis()));
        }
        if (filter.masaKonum() != null) {
            query.where(root.masaKonum.eq(MasaKonum.valueOf(filter.masaKonum())));
        }

        return query.fetch();
    }
}