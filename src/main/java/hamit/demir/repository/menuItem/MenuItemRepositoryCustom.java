package hamit.demir.repository.menuItem;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;

import java.util.List;

public interface MenuItemRepositoryCustom {

    List<MenuItemResponse> fetchAllMenuItems();

    MenuItemResponse fetchMenuItemById(Long id);
}
