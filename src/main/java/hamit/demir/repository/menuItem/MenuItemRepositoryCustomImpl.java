package hamit.demir.repository.menuItem;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MenuItemRepositoryCustomImpl extends QuerydslRepositorySupport implements MenuItemRepositoryCustom {
    public MenuItemRepositoryCustomImpl() {
        super(MenuItemEntity.class);
    }


    @Override
    public List<MenuItemResponse> fetchAllMenuItems() {
        QMenuItemEntity root = QMenuItemEntity.menuItemEntity;
        QMenuCategoryEntity menuCategory = QMenuCategoryEntity.menuCategoryEntity;

        return from(root).leftJoin(root.kategori,menuCategory).select(Projections.constructor(MenuItemResponse.class,
                root.id,
                root.ad,
                root.aciklama,
                Projections.constructor(ProjeIdAdRecord.class,
                menuCategory.id,
                menuCategory.ad),
                root.aktif,
                root.resimYolu,
                root.ekOzellikler,
                root.olusturmaTarih,
                root.guncelemeTarih
        )).fetch();
    }

    @Override
    public MenuItemResponse fetchMenuItemById(Long id) {
        QMenuItemEntity root = QMenuItemEntity.menuItemEntity;
        QMenuCategoryEntity menuCategory = QMenuCategoryEntity.menuCategoryEntity;

        return from(root).leftJoin(root.kategori,menuCategory).select(Projections.constructor(MenuItemResponse.class,
                root.id,
                root.ad,
                root.aciklama,
                Projections.constructor(ProjeIdAdRecord.class,
                        menuCategory.id,
                        menuCategory.ad),
                root.aktif,
                root.resimYolu,
                root.ekOzellikler,
                root.olusturmaTarih,
                root.guncelemeTarih
        )).where(root.id.eq(id).and(root.aktif.eq(true))).fetchOne();
    }
}
