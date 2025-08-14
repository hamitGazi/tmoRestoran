package hamit.demir.repository.menuFiyat;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class MenuFiyatRepositoryCustomImpl extends QuerydslRepositorySupport implements MenuFiyatRepositoryCustom {
    public MenuFiyatRepositoryCustomImpl() {
        super(MenuFiyatEntity.class);
    }


    @Override
    public List<MenuFiyatAllResponse> fetchAllMenuFiyatList() {

        QMenuFiyatEntity root = QMenuFiyatEntity.menuFiyatEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;

        return from(root).leftJoin(root.menuItem, menuItem).select(Projections.constructor(MenuFiyatAllResponse.class,
                root.id,
                Projections.constructor(ProjeIdAdRecord.class,
                        menuItem.id,
                        menuItem.ad),
                root.fiyat,
                root.gecerlilikBaslangic,
                root.gecerlilikBitis,
                root.aktif,
                root.olusturmaTarih,
                root.guncelleTarih)).fetch();
    }

    @Override
    public MenuFiyatAllResponse fetchMenuFiyatById(Long id ) {
        QMenuFiyatEntity root = QMenuFiyatEntity.menuFiyatEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;

        return from(root).leftJoin(root.menuItem, menuItem).select(Projections.constructor(MenuFiyatAllResponse.class,
                root.id,
                Projections.constructor(ProjeIdAdRecord.class,
                        menuItem.id,
                        menuItem.ad),
                root.fiyat,
                root.gecerlilikBaslangic,
                root.gecerlilikBitis,
                root.aktif,
                root.olusturmaTarih,
                root.guncelleTarih)).where(root.id.eq(id).and(root.aktif.eq(true))).fetchOne();
    }

    @Override
    public List<MenuFiyatEntity> fetMenuFiyatInIds(List<Long> itemIds, LocalDateTime now) {
        QMenuFiyatEntity root = QMenuFiyatEntity.menuFiyatEntity;

        return from(root).select(Projections.constructor(MenuFiyatEntity.class,
                        root.id,
                        root.menuItem,
                        root.fiyat,
                        root.gecerlilikBaslangic,
                        root.gecerlilikBitis,
                        root.aktif,
                        root.olusturmaTarih,
                        root.guncelleTarih)).
                where(
                        root.menuItem.id.in(itemIds)
                                .and(root.aktif.eq(true))
                                /*.and(root.gecerlilikBaslangic.loe(now))
                                .and(root.gecerlilikBitis.isNull().or(root.gecerlilikBitis.goe(now)))*/
                )
                .fetch();
    }

    @Override
    public BigDecimal fetchMenuItemFiyat(Long menuItemId) {
        QMenuFiyatEntity root = QMenuFiyatEntity.menuFiyatEntity;
        return from(root).select(root.fiyat).
                where(root.menuItem.id.eq(menuItemId).and(root.aktif.eq(true))
                 /*.and(root.gecerlilikBaslangic.loe(now))
                                .and(root.gecerlilikBitis.isNull().or(root.gecerlilikBitis.goe(now)))*/
                ).fetchOne();
    }
}