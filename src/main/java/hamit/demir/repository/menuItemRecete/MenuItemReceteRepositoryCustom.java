package hamit.demir.repository.menuItemRecete;

import hamit.demir.model.dto.menuItem.MenuItemByCategoryIdResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteResponse;
import hamit.demir.model.entity.MenuItemReceteEntity;

import java.util.List;

public interface MenuItemReceteRepositoryCustom {



    List<MenuItemReceteResponse> fetchAllReceteler();

    MenuItemReceteResponse fetchReceteById(Long id);

    List<MenuItemReceteResponse> fetchRecetelerByMenuUrunId(Long menuUrunId);

    List<MenuItemReceteResponse> fetchSiraliKalemByUrunId(Long id);

    List<MenuItemReceteEntity> fetchReceteIdsByMenuItemIds(List<Long> itemIds);

    List<MenuItemReceteEntity> fetchRecetelerByMenuItemId(long id);
}
