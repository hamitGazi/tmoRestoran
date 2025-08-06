package hamit.demir.repository.musteri;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.musteri.MusteriResponse;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MusteriEntity;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QMusteriEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MusteriRepositoryCustomImpl extends QuerydslRepositorySupport implements MusteriRepositoryCustom {
    public MusteriRepositoryCustomImpl() {
        super(MusteriEntity.class);
    }


    @Override
    public List<MusteriResponse> fetchAllMusterler() {
        QMusteriEntity root = QMusteriEntity.musteriEntity;

        return from(root).select(Projections.constructor(MusteriResponse.class,
                root.id,
                root.ad,
                root.soyad,
                root.telefon,
                root.email,
                root.olusturmaTarih
           /*     root.guncelleTarih*/
                )).fetch();
    }

    @Override
    public MusteriResponse fetchMusteriById(Long id) {
        QMusteriEntity root = QMusteriEntity.musteriEntity;

        return from(root).select(Projections.constructor(MusteriResponse.class,
                root.id,
                root.ad,
                root.soyad,
                root.telefon,
                root.email,
                root.olusturmaTarih
               /* root.guncelleTarih*/
        )).where(root.id.eq(id)).fetchOne();
    }
}
