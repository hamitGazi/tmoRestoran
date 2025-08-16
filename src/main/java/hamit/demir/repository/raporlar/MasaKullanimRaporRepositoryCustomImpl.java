package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKullanimRaporFilterRequest;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKulanimRaporFilterResponse;
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
    public List<MasaKulanimRaporFilterResponse> fetchMasaKullanimRaporlari(MasaKullanimRaporFilterRequest filter) {
        QMasaEntity root = QMasaEntity.masaEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        NumberExpression<Integer> gecenSureExpr = Expressions.numberTemplate(Integer.class,
                "function('datediff', {0}, {1})",
                siparis.guncelleZamani,
                siparis.olusturmaZamani
        );

        var query = from(root)
                .leftJoin(siparis).on(siparis.masa.id.eq(root.id))
                .select(Projections.constructor(MasaKulanimRaporFilterResponse.class,
                        root.id,
                        root.masaKonum,
                        gecenSureExpr,
                        siparis.id.count().intValue(),
                        siparis.olusturmaZamani
                ))
                .groupBy(root.id, root.masaKonum, siparis.guncelleZamani, siparis.olusturmaZamani);


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