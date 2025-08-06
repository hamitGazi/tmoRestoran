package hamit.demir.repository.siparisKalemi;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.siparis.SiparisResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class SiparisKalemRepositoryCustomImpl extends QuerydslRepositorySupport implements SiparisKalemRepositoryCustom {
    public SiparisKalemRepositoryCustomImpl() {
        super(SiparisKalemiEntity.class);
    }


    @Override
    public List<SiparisKalemiResponse> getAllSiparisKalemler() {
        QSiparisKalemiEntity root = QSiparisKalemiEntity.siparisKalemiEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;
        return from(root).leftJoin(root.siparis,siparis).leftJoin(root.menuItem,menuItem)
                .select(Projections.constructor(SiparisKalemiResponse.class,
                        root.id,
                        Projections.constructor(SiparisResponse.class,
                                siparis.id),
                        Projections.constructor(SiparisResponse.class,
                                menuItem.id,
                                menuItem.ad),
                        root.adet,
                        root.birimFiyat,
                        root.toplamFiyat,
                        root.ekOzellikler,
                        root.not
                        )).fetch();
    }

    @Override
    public SiparisKalemiResponse fetchSiparisKalemiById(Long id) {
        QSiparisKalemiEntity root = QSiparisKalemiEntity.siparisKalemiEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;
        return from(root).leftJoin(root.siparis,siparis).leftJoin(root.menuItem,menuItem)
                .select(Projections.constructor(SiparisKalemiResponse.class,
                        root.id,
                        Projections.constructor(SiparisResponse.class,
                                siparis.id),
                        Projections.constructor(SiparisResponse.class,
                                menuItem.id,
                                menuItem.ad),
                        root.adet,
                        root.birimFiyat,
                        root.toplamFiyat,
                        root.ekOzellikler,
                        root.not
                )).where(root.id.eq(id)).fetchOne();
    }
}
