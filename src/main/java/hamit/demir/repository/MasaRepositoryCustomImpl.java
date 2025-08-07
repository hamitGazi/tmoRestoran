package hamit.demir.repository;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.QMasaEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MasaRepositoryCustomImpl extends QuerydslRepositorySupport implements MasaRepositoryCustom {
    public MasaRepositoryCustomImpl() {
        super(MasaEntity.class);
    }

    @Override
    public List<MasaResponse> fetchAllMasalar() {
        QMasaEntity root = QMasaEntity.masaEntity;
        return from(root).select(Projections.constructor(MasaResponse.class,
                root.id,
                root.qrKodUrl,
                root.kapasite,
                root.masaKonum,
                root.masaDurum,
                root.olusturmaTarih,
                root.guncelemeTarih
        )).fetch();
    }

    @Override
    public MasaResponse fetchMasaById(Long id) {
        QMasaEntity root = QMasaEntity.masaEntity;
        return from(root).select(Projections.constructor(MasaResponse.class,
                root.id,
                root.qrKodUrl,
                root.kapasite,
                root.masaKonum,
                root.masaDurum,
                root.olusturmaTarih,
                root.guncelemeTarih
        )).where(root.id.eq(id)).fetchOne();
    }
}
