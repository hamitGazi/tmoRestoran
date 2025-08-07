package hamit.demir.repository.menuFiyat;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MenuFiyatRepositoryCustomImpl extends QuerydslRepositorySupport implements MenuFiyatRepositoryCustom {
    public MenuFiyatRepositoryCustomImpl() {
        super(MenuFiyatEntity.class);
    }


    @Override
    public List<MenuFiyatResponse> fetchAllMenuFiyatList() {

        QMenuFiyatEntity root = QMenuFiyatEntity.menuFiyatEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;

        return from(root).leftJoin(root.menuItem,menuItem).select(Projections.constructor(MenuFiyatResponse.class,
                root.id,
                Projections.constructor(ProjeIdAdRecord.class,
                menuItem.id,
                menuItem.ad),
                root.fiyat,
                root.indirimFiyati,
                root.gecerlilikBaslangic,
                root.gecerlilikBitis,
                root.aktif,
                root.olusturmaTarih,
                root.guncelleTarih)).fetch();
    }

    @Override
    public MenuFiyatResponse fetchMenuFiyatById(Long id) {
        QMenuFiyatEntity root = QMenuFiyatEntity.menuFiyatEntity;
        QMenuItemEntity menuItem = QMenuItemEntity.menuItemEntity;

        return from(root).leftJoin(root.menuItem,menuItem).select(Projections.constructor(MenuFiyatResponse.class,
                root.id,
                Projections.constructor(ProjeIdAdRecord.class,
                        menuItem.id,
                        menuItem.ad),
                root.fiyat,
                root.indirimFiyati,
                root.gecerlilikBaslangic,
                root.gecerlilikBitis,
                root.aktif,
                root.olusturmaTarih,
                root.guncelleTarih)).where(root.id.eq(id).and(root.aktif.eq(true))).fetchOne();
    }
}
