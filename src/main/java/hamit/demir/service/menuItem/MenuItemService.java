package hamit.demir.service.menuItem;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface MenuItemService {

    List<MenuItemResponse> getAllMenuItems();

    MenuItemResponse getMenuItemById(Long id);

    Long saveMenuItem(MenuItemSaveRequest request);

    Long updateMenuItem(MenuItemUpdateRequest request);

    String deleteMenuItem(Long id);
}
