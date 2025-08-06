package hamit.demir.repository.menuCategory;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.entity.MenuCategoryEntity;
import hamit.demir.model.entity.QMenuCategoryEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MenuCategoryRepositoryCustomImpl extends QuerydslRepositorySupport implements MenuCategoryRepositoryCustom {
    public MenuCategoryRepositoryCustomImpl() {
        super(MenuCategoryEntity.class);
    }


    @Override
    public MenuCategoryResponse fetchMenuCategoryById(long id) {
        QMenuCategoryEntity root = QMenuCategoryEntity.menuCategoryEntity;
        return from(root).select(Projections.constructor(MenuCategoryResponse.class,
                root.id,
                root.ad,
                root.aciklama,
                root.menuSira,
                root.aktif,
                root.olusturmaTarih,
                root.guncelemeTarih
        )).where(root.id.eq(id).and(root.aktif.eq(true))).fetchOne();
    }


    @Override
    public List<MenuCategoryResponse> fetchAllMenuCategory() {
        QMenuCategoryEntity root = QMenuCategoryEntity.menuCategoryEntity;
        return from(root).select(Projections.constructor(MenuCategoryResponse.class,
                root.id,
                root.ad,
                root.aciklama,
                root.menuSira,
                root.aktif,
                root.olusturmaTarih,
                root.guncelemeTarih
                )).fetch();
    }
}
