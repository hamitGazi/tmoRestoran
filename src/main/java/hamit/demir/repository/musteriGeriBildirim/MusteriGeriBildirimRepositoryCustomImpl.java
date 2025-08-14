package hamit.demir.repository.musteriGeriBildirim;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.entity.MusteriGeriBildirimEntity;
import hamit.demir.model.entity.QMusteriGeriBildirimEntity;
import hamit.demir.model.entity.QSiparisEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MusteriGeriBildirimRepositoryCustomImpl extends QuerydslRepositorySupport implements MusteriGeriBildirimRepositoryCustom {
    public MusteriGeriBildirimRepositoryCustomImpl() {
        super(MusteriGeriBildirimEntity.class);
    }

    @Override
    public List<MusteriGeriBildirimResponse> fetchAllMusteriGeriBildirims() {
        QMusteriGeriBildirimEntity root = QMusteriGeriBildirimEntity.musteriGeriBildirimEntity;

        return from(root).select(Projections.constructor(MusteriGeriBildirimResponse.class,
                root.id,
                root.siparis,
                root.puan,
                root.yorum,
                root.musteriAd,
                root.geriBildirimTur,
                root.olusturmaTarih,
                root.guncelleTarih)).fetch();
    }

    @Override
    public MusteriGeriBildirimResponse fetchMusteriGeriBildirimById(Long id) {
        QMusteriGeriBildirimEntity root = QMusteriGeriBildirimEntity.musteriGeriBildirimEntity;
        return from(root).select(Projections.constructor(MusteriGeriBildirimResponse.class,
                root.id,
                root.siparis,
                root.puan,
                root.yorum,
                root.musteriAd,
                root.geriBildirimTur,
                root.olusturmaTarih,
                root.guncelleTarih)).where(root.id.eq(id)).fetchOne();
    }
}
