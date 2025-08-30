package hamit.demir.repository.tatilGun;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.tatilGun.TatilGunResponse;
import hamit.demir.model.entity.QTatilGunEntity;
import hamit.demir.model.entity.TatilGunEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.util.List;

public class TatilGunRepositoryCustomImpl extends QuerydslRepositorySupport implements TatilGunRepositoryCustom {
    public TatilGunRepositoryCustomImpl() {
        super(TatilGunEntity.class);
    }



    @Override
    public List<TatilGunResponse> fetchAllTatilGunleri() {
        QTatilGunEntity root = QTatilGunEntity.tatilGunEntity;

        return from(root)
                .select(Projections.constructor(TatilGunResponse.class,
                        root.id,
                        root.tarih,
                        root.tatilTip,
                        root.calismaZaman.id,
                        root.calismaZaman.gun,
                        root.aciklama,
                        root.aktif
                ))
                .orderBy(root.tarih.asc())
                .fetch();
    }

    @Override
    public TatilGunResponse fetchTatilGunById(Long id) {
        QTatilGunEntity root = QTatilGunEntity.tatilGunEntity;

        return from(root)
                .select(Projections.constructor(TatilGunResponse.class,
                        root.id,
                        root.tarih,
                        root.tatilTip,
                        root.calismaZaman.id,
                        root.calismaZaman.gun,
                        root.aciklama,
                        root.aktif
                ))
                .where(root.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<TatilGunResponse> fetchTatilGunByCalismaZamanId(Long calismaZamanId) {
        QTatilGunEntity root = QTatilGunEntity.tatilGunEntity;

        return from(root)
                .select(Projections.constructor(TatilGunResponse.class,
                        root.id,
                        root.tarih,
                        root.tatilTip,
                        root.calismaZaman.id,
                        root.calismaZaman.gun,
                        root.aciklama,
                        root.aktif
                ))
                .where(root.calismaZaman.id.eq(calismaZamanId).and(root.aktif.eq(true)))
                .orderBy(root.tarih.asc())
                .fetch();
    }

    @Override
    public TatilGunEntity fetchGecerliTatil(LocalDate date) {
        QTatilGunEntity root = QTatilGunEntity.tatilGunEntity;

        return from(root)
                .select(root)
                .where(root.tarih.eq(date).and(root.aktif.eq(true)))
                .fetchOne();
    }