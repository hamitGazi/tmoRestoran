package hamit.demir.controller;

import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import hamit.demir.service.menuCategory.MenuCategoryService;
import hamit.demir.service.menuItem.MenuItemService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("menu-item")
@RequiredArgsConstructor
public class MenuItemController {
    private final MenuItemService menuItemService;

    @GetMapping("all")
    public GenericRespose<List<MenuItemResponse>> getAllMenuItems() {
        List<MenuItemResponse> allMenuItems = menuItemService.getAllMenuItems();
        return GenericRespose.ok(allMenuItems);
    }

    @GetMapping("/{id}")
    public GenericRespose<MenuItemResponse> getMenuItem(@PathVariable Long id) {
        MenuItemResponse menuItemById = menuItemService.getMenuItemById(id);
        return GenericRespose.ok(menuItemById);
    }

    @PostMapping("save")
    public GenericRespose<Long> saveMenuItem(@Valid @RequestBody MenuItemSaveRequest request) {
        Long id = menuItemService.saveMenuItem(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateMenuItem(@Valid @RequestBody MenuItemUpdateRequest request) {
        Long id = menuItemService.updateMenuItem(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericRespose<String> deleteMenuItem(@PathVariable Long id) {
        String str = menuItemService.deleteMenuItem(id);
        return GenericRespose.ok(str);


    }


}
