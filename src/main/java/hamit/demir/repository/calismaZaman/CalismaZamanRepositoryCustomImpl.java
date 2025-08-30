package hamit.demir.repository.calismaZaman;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.calisZaman.CalismaZamanResponse;
import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.model.entity.CalismaZamanEntity;

import hamit.demir.model.entity.QCalismaZamanEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.util.List;

public class CalismaZamanRepositoryCustomImpl extends QuerydslRepositorySupport implements CalismaZamanRepositoryCustom {
    public CalismaZamanRepositoryCustomImpl() {
        super(CalismaZamanEntity.class);
    }
    @Override
    public List<CalismaZamanResponse> fetchAllCalismaZamanlar() {
        QCalismaZamanEntity root = QCalismaZamanEntity.calismaZamanEntity;

        return from(root)
                .select(Projections.constructor(CalismaZamanResponse.class,
                        root.id,
                        root.gun,
                        root.acilisSaat,
                        root.kapanisSaat,
                        root.tatil,
                        root.aktif,
                        root.aciklama
                ))
                .orderBy(root.gun.asc())
                .fetch();
    }
    @Override
    public List<CalismaZamanResponse> fetchAktifIstisnaZaman() {
        QCalismaZamanEntity root = QCalismaZamanEntity.calismaZamanEntity;

        return from(root)
                .select(Projections.constructor(CalismaZamanResponse.class,
                        root.id,
                        root.gun,
                        root.acilisSaat,
                        root.kapanisSaat,
                        root.tatil,
                        root.aktif,
                        root.aciklama
                ))
                .where(root.aktif.eq(true).and(root.istisna.eq(true)))
                .orderBy(root.gun.asc())
                .fetch();
    }
    @Override
    public CalismaZamanResponse fetchCalismaZamanById(Long id) {
        QCalismaZamanEntity root = QCalismaZamanEntity.calismaZamanEntity;

        return from(root)
                .select(Projections.constructor(CalismaZamanResponse.class,
                        root.id,
                        root.gun,
                        root.acilisSaat,
                        root.kapanisSaat,
                        root.tatil,
                        root.aktif,
                        root.aciklama
                ))
                .where(root.id.eq(id))
                .fetchOne();
    }

    @Override
    public CalismaZamanEntity fetchGecerliCalismaZaman(CalismaGunEnum gun) {
        QCalismaZamanEntity root = QCalismaZamanEntity.calismaZamanEntity;

        return from(root)
                .select(root)
                .where(
                        root.gun.eq(gun)
                                .and(root.aktif.eq(true))
                                .and(
                                        root.bitisTarih.isNull()
                                                .or(root.bitisTarih.goe(LocalDate.now())))).fetchOne();
    }
}


