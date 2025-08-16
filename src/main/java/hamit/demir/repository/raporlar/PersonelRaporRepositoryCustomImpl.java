package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterRequest;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PersonelRaporRepositoryCustomImpl extends QuerydslRepositorySupport implements PersonelRaporRepositoryCustom {
    public PersonelRaporRepositoryCustomImpl() {
        super(PersonelEntity.class);
    }


    @Override
    public List<PersonelRaporFilterResponse> fetchPersonelRaporlari(PersonelRaporFilterRequest filter) {
        QPersonelEntity root = QPersonelEntity.personelEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        NumberExpression<Integer> gecenSureExpr = Expressions.numberTemplate(Integer.class,
                "function('datediff', {0}, {1})",
                siparis.guncelleZamani,
                siparis.olusturmaZamani
        );

        var query = from(root)
                .leftJoin(siparis).on(siparis.personel.id.eq(root.id))
                .select(Projections.constructor(PersonelRaporFilterResponse.class,
                        root.id,
                        root.ad.concat(" ").concat(root.soyad),
                        root.rol,//PersonelRolEnum
                        siparis.id.count().intValue(),
                        siparis.toplamTutar.sumBigDecimal(),
                        gecenSureExpr
                ))
                .groupBy(root.id);

        if (filter.gecerlilikBaslangic() != null) {
            query.where(siparis.olusturmaZamani.goe(filter.gecerlilikBaslangic()));
        }
        if (filter.gecerlilikBitis() != null) {
            query.where(siparis.olusturmaZamani.loe(filter.gecerlilikBitis()));
        }
        if (filter.rol() != null) {
            query.where(root.rol.eq(PersonelRol.valueOf(filter.rol())));
        }

        return query.fetch();
    }
}