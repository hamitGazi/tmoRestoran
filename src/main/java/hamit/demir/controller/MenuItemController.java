package hamit.demir.controller;

import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import hamit.demir.service.menuCategory.MenuCategoryService;
import hamit.demir.service.menuItem.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu-item")
@RequiredArgsConstructor
public class MenuItemController {
    private final MenuItemService menuItemService;

    @GetMapping
    public List<MenuItemResponse> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuItemResponse getMenuItem(@PathVariable Long id) {
        return menuItemService.getMenuItemById(id);
    }

    @PostMapping
    public Long saveMenuItem(@Valid @RequestBody MenuItemSaveRequest request) {
        return menuItemService.saveMenuItem(request);
    }

    @PutMapping
    public Long updateMenuItem(@Valid @RequestBody MenuItemUpdateRequest request) {
        return menuItemService.updateMenuItem(request);
    }

    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Long id) {
        return menuItemService.deleteMenuItem(id);
    }


}
