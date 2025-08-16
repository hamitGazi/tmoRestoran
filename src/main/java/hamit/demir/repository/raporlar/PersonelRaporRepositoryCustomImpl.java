package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.PersonelRaporFilterResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PersonelRaporRepositoryCustomImpl extends QuerydslRepositorySupport implements PersonelRaporRepositoryCustom {
    public PersonelRaporRepositoryCustomImpl() {
        super(PersonelEntity.class);
    }


    @Override
    public List<PersonelRaporFilterResponse> fetchPersonelRaporlari(PersonelRaporFilterResponse filter) {
        QPersonelEntity root = QPersonelEntity.personelEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;

        var query = from(root)
                .leftJoin(siparis).on(siparis.personel.id.eq(root.id))
                .select(Projections.constructor(PersonelRaporFilterResponse.class,
                        root.id,
                        root.ad.concat(" ").concat(root.soyad),
                        new EnumRecord(root.rol.name(), root.rol.getLabel()),
                        siparis.id.count().intValue(),
                        siparis.toplamTutar.sum(),
                        siparis.guncelleZamani.subtract(siparis.olusturmaZamani).castToNum(Integer.class)
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