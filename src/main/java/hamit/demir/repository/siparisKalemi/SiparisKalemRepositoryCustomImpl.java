package hamit.demir.repository.siparisKalemi;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaIdKodResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class SiparisKalemRepositoryCustomImpl extends QuerydslRepositorySupport implements SiparisKalemRepositoryCustom {
    public SiparisKalemRepositoryCustomImpl() {
        super(SiparisKalemiEntity.class);
    }


    @Override
    public List<SiparisKalemiResponse> fetchAllSiparisKalemler() {
        QSiparisKalemiEntity root = QSiparisKalemiEntity.siparisKalemiEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        return from(root).leftJoin(root.siparis, siparis).leftJoin(root.menuItem, menuItem).leftJoin(siparis.masa, masa)
                .select(Projections.constructor(SiparisKalemiResponse.class,
                        root.id,
                        Projections.constructor(MasaIdKodResponse.class,
                                masa.id,
                                masa.qrKodUrl),
                        root.siparis.id,
                        Projections.constructor(ProjeIdAdRecord.class,
                                menuItem.id,
                                menuItem.ad),
                        root.adet,
                        root.birimFiyat,
                        root.toplamFiyat,
                        root.ekOzellikler,
                        siparis.siparisDurumu,
                        root.kalemNot
                )).fetch();
    }

    @Override
    public SiparisKalemiResponse fetchSiparisKalemiById(Long id) {
        QSiparisKalemiEntity root = QSiparisKalemiEntity.siparisKalemiEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        return from(root).leftJoin(root.siparis, siparis).leftJoin(root.menuItem, menuItem).leftJoin(siparis.masa, masa)
                .select(Projections.constructor(SiparisKalemiResponse.class,
                        root.id,
                        Projections.constructor(MasaIdKodResponse.class,
                                masa.id,
                                masa.qrKodUrl),
                        root.siparis.id,
                        Projections.constructor(ProjeIdAdRecord.class,
                                menuItem.id,
                                menuItem.ad),
                        root.adet,
                        root.birimFiyat,
                        root.toplamFiyat,
                        root.ekOzellikler,
                        siparis.siparisDurumu,
                        root.kalemNot
                )).where(root.id.eq(id)).fetchOne();
    }

    @Override
    public List<SiparisKalemiEntity> fetchSiparisKalemiListBySiparisId(Long siparisId) {
        QSiparisKalemiEntity root = QSiparisKalemiEntity.siparisKalemiEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;

      return from(root).leftJoin(root.siparis, siparis).leftJoin(root.menuItem, menuItem).leftJoin(siparis.masa, masa)
                .where(root.siparis.id.eq(siparisId))
                .select(Projections.constructor(
                        SiparisKalemiEntity.class,
                        root.id,
                        root.siparis,
                        root.menuItem,
                        root.adet,
                        root.birimFiyat,
                        root.toplamFiyat,
                        root.ekOzellikler,
                        siparis.siparisDurumu,
                        root.kalemNot
                ))
                .fetch();
    }

    @Override
    public List<SiparisKalemiResponse> fetchKalemlerBySiparisId(Long id) {
        QSiparisKalemiEntity root = QSiparisKalemiEntity.siparisKalemiEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;
        QSiparisEntity siparis = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        return from(root).leftJoin(root.siparis, siparis).leftJoin(root.menuItem, menuItem).leftJoin(siparis.masa, masa)
                .select(Projections.constructor(SiparisKalemiResponse.class,
                        root.id,
                        Projections.constructor(MasaIdKodResponse.class,
                                masa.id,
                                masa.qrKodUrl),
                        root.siparis.id,
                        Projections.constructor(ProjeIdAdRecord.class,
                                menuItem.id,
                                menuItem.ad),

                        root.adet,
                        root.birimFiyat,
                        root.toplamFiyat,
                        root.ekOzellikler,
                        siparis.siparisDurumu,
                        root.kalemNot
                )).where(root.siparis.id.eq(id)).fetch();
    }
}
