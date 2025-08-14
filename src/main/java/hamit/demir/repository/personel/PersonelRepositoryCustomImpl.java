package hamit.demir.repository.personel;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.personel.PersonelAllResponse;
import hamit.demir.model.entity.PersonelEntity;
import hamit.demir.model.entity.QPersonelEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PersonelRepositoryCustomImpl extends QuerydslRepositorySupport implements PersonelRepositoryCustom {
    public PersonelRepositoryCustomImpl() {
        super(PersonelEntity.class);
    }


    @Override
    public List<PersonelAllResponse> fetchAllPersonel() {
        QPersonelEntity root= QPersonelEntity.personelEntity;

        return from(root).select(Projections.constructor(PersonelAllResponse.class,
                root.id,
                root.ad,
                root.soyad,
                root.email,
                root.rol,
                root.aktif,
                root.olusturTarih,
                root.guncelleTarih)).fetch();
    }

    @Override
    public PersonelAllResponse fetchPersonelById(Long id) {
        QPersonelEntity root= QPersonelEntity.personelEntity;


        return from(root).select(Projections.constructor(PersonelAllResponse.class,
                root.id,
                root.ad,
                root.soyad,
                root.email,
                root.rol,
                root.aktif,
                root.olusturTarih,
                root.guncelleTarih)).where(root.aktif.eq(true).and(root.id.eq(id))).fetchOne();
    }

}
