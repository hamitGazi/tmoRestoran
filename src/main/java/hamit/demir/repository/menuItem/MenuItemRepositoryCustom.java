package hamit.demir.repository.menuItem;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.menuItem.MenuItemByCategoryIdResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public interface MenuItemRepositoryCustom {

    List<MenuItemResponse> fetchAllMenuItems();

    MenuItemResponse fetchMenuItemById(Long id);

    List<MenuItemByCategoryIdResponse> fetchMenuItemByMenuCategoryId(Long id);


}
