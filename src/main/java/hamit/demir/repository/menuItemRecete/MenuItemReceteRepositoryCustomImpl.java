package hamit.demir.repository.menuItemRecete;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.StokKalemi.StokMenuItemReceteResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteResponse;
import hamit.demir.model.entity.MenuItemReceteEntity;
import hamit.demir.model.entity.QMenuItemEntity;
import hamit.demir.model.entity.QMenuItemReceteEntity;
import hamit.demir.model.entity.QStokKalemiEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MenuItemReceteRepositoryCustomImpl extends QuerydslRepositorySupport implements MenuItemReceteRepositoryCustom {
    public MenuItemReceteRepositoryCustomImpl() {
        super(MenuItemReceteEntity.class);
    }

    @Override
    public List<MenuItemReceteResponse> fetchAllReceteler() {

        QMenuItemReceteEntity root = QMenuItemReceteEntity.menuItemReceteEntity;
        QMenuItemEntity menuUrun = QMenuItemEntity.menuItemEntity;
        QStokKalemiEntity stokKalem = QStokKalemiEntity.stokKalemiEntity;

        return from(root)
                .leftJoin(root.menuUrun, menuUrun)
                .leftJoin(root.stokKalemi, stokKalem)
                .select(Projections.constructor(MenuItemReceteResponse.class,
                        root.id,
                        Projections.constructor(ProjeIdAdRecord.class,
                                menuUrun.id,
                                menuUrun.ad),
                        Projections.constructor(StokMenuItemReceteResponse.class,
                                stokKalem.id,
                                stokKalem.ad,
                                stokKalem.miktar,
                                stokKalem.birim),
                        root.miktar,
                        root.birim,
                        root.olusturmaTarih,
                        root.guncelleTarih))
                .fetch();
    }

    @Override
    public MenuItemReceteResponse fetchReceteById(Long id) {
        QMenuItemReceteEntity root = QMenuItemReceteEntity.menuItemReceteEntity;
        QMenuItemEntity menuUrun = QMenuItemEntity.menuItemEntity;
        QStokKalemiEntity stokKalem = QStokKalemiEntity.stokKalemiEntity;

        return from(root)
                .leftJoin(root.menuUrun, menuUrun)
                .leftJoin(root.stokKalemi, stokKalem)
                .select(Projections.constructor(MenuItemReceteResponse.class,
                        root.id,
                        Projections.constructor(ProjeIdAdRecord.class, menuUrun.id, menuUrun.ad),
                        Projections.constructor(StokMenuItemReceteResponse.class,
                                stokKalem.id,
                                stokKalem.ad,
                                stokKalem.miktar,
                                stokKalem.birim
                        ),
                        root.miktar,
                        root.birim,
                        root.olusturmaTarih,
                        root.guncelleTarih))
                .where(root.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<MenuItemReceteResponse> fetchRecetelerByMenuUrunId(Long menuUrunId) {
        QMenuItemReceteEntity root = QMenuItemReceteEntity.menuItemReceteEntity;
        QMenuItemEntity menuUrun = QMenuItemEntity.menuItemEntity;
        QStokKalemiEntity stokKalemi = QStokKalemiEntity.stokKalemiEntity;

        return from(root)
                .leftJoin(root.menuUrun, menuUrun)
                .leftJoin(root.stokKalemi, stokKalemi)
                .select(Projections.constructor(MenuItemReceteResponse.class,
                        root.id,
                        Projections.constructor(ProjeIdAdRecord.class, menuUrun.id, menuUrun.ad),
                        Projections.constructor(ProjeIdAdRecord.class, stokKalemi.id, stokKalemi.ad),
                        root.miktar,
                        root.birim))
                .where(root.menuUrun.id.eq(menuUrunId))
                .fetch();
    }

    @Override
    public List<MenuItemReceteResponse> fetchSiraliKalemByUrunId(Long id) {
        QMenuItemReceteEntity root = QMenuItemReceteEntity.menuItemReceteEntity;
        QMenuItemEntity menuUrun = QMenuItemEntity.menuItemEntity;
        QStokKalemiEntity stokKalem = QStokKalemiEntity.stokKalemiEntity;
        return from(root)
                .leftJoin(root.menuUrun, menuUrun)
                .leftJoin(root.stokKalemi, stokKalem)
                .select(Projections.constructor(MenuItemReceteResponse.class,
                        root.id,
                        Projections.constructor(ProjeIdAdRecord.class, menuUrun.id, menuUrun.ad),
                        Projections.constructor(StokMenuItemReceteResponse.class,
                                stokKalem.id,
                                stokKalem.ad,
                                stokKalem.miktar,
                                stokKalem.birim
                        ),
                        root.miktar,
                        root.birim,
                        root.olusturmaTarih,
                        root.guncelleTarih))
                .where(root.menuUrun.id.eq(id)).orderBy(root.id.desc())
                .fetch();
    }

    @Override
    public List<MenuItemReceteEntity> fetchReceteIdsByMenuItemIds(List<Long> itemIds) {
        QMenuItemReceteEntity root = QMenuItemReceteEntity.menuItemReceteEntity;

        return from(root)
                .select(Projections.constructor(MenuItemReceteEntity.class,
                        root.id,
                        root.menuUrun,
                        root.stokKalemi,
                        root.miktar,
                        root.birim,
                        root.olusturmaTarih,
                        root.guncelleTarih))
                .where(root.menuUrun.id.in(itemIds))
                .fetch();
    }

    @Override
    public List<MenuItemReceteEntity> fetchRecetelerByMenuItemId(long id) {
        QMenuItemReceteEntity root = QMenuItemReceteEntity.menuItemReceteEntity;

        return from(root)
                .select(Projections.constructor(MenuItemReceteEntity.class,
                        root.id,
                        root.menuUrun,
                        root.stokKalemi,
                        root.miktar,
                        root.birim,
                        root.olusturmaTarih,
                        root.guncelleTarih))
                .where(root.menuUrun.id.eq(id))
                .fetch();
    }

}