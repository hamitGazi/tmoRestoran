package hamit.demir.repository.stokKalem;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QStokKalemiEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class StokKalemRepositoryCustomImpl extends QuerydslRepositorySupport implements StokKalemRepositoryCustom {
    public StokKalemRepositoryCustomImpl() {
        super(QStokKalemiEntity.class);
    }


    @Override
    public List<StokKalemiResponse> fetchAllStokKalemler() {
        QStokKalemiEntity root =QStokKalemiEntity.stokKalemiEntity;

        return from(root).select(Projections.constructor(StokKalemiResponse.class,
                root.id,
                root.ad,
                root.miktar,
                root.kritikMiktar,
                root.birim,
                root.aciklama,
                root.aktif,
                root.olusturmaTarih,
                root.guncelleTarih)).where(root.aktif).fetch();
    }

    @Override
    public StokKalemiResponse fetchStokKalemById(Long id) {
        QStokKalemiEntity root =QStokKalemiEntity.stokKalemiEntity;

        return from(root).select(Projections.constructor(StokKalemiResponse.class,
                        root.id,
                        root.ad,
                        root.miktar,
                        root.kritikMiktar,
                        root.birim,
                        root.aciklama,
                        root.aktif,
                        root.olusturmaTarih,
                        root.guncelleTarih)).
                where(root.id.eq(id).and(root.aktif.eq(true)))
                .fetchOne();
    }
}
