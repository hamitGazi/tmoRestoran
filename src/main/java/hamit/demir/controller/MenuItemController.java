package hamit.demir.controller;

import hamit.demir.model.dto.menuItem.MenuItemByCategoryIdResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import hamit.demir.service.menuItem.MenuItemService;
import hamit.demir.utils.GenericResponse;
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
    public GenericResponse<List<MenuItemResponse>> getAllMenuItems() {
        List<MenuItemResponse> allMenuItems = menuItemService.getAllMenuItems();
        return GenericResponse.ok(allMenuItems);
    }

    @GetMapping("/{id}")
    public GenericResponse<MenuItemResponse> getMenuItem(@PathVariable Long id) {
        MenuItemResponse menuItemById = menuItemService.getMenuItemById(id);
        return GenericResponse.ok(menuItemById);
    }

    @PostMapping("save")
    public GenericResponse<Long> saveMenuItem(@Valid @RequestBody MenuItemSaveRequest request) {
        Long id = menuItemService.saveMenuItem(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateMenuItem(@Valid @RequestBody MenuItemUpdateRequest request) {
        Long id = menuItemService.updateMenuItem(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteMenuItem(@PathVariable Long id) {
        String str = menuItemService.deleteMenuItem(id);
        return GenericResponse.ok(str);
    }

    @GetMapping("by-categoryId/{id}")
    public GenericResponse<List<MenuItemByCategoryIdResponse>> getMenuItemByMenuCategoryId(@PathVariable Long id) {
        List<MenuItemByCategoryIdResponse> menuItemByMenuCategory = menuItemService.getMenuItemByMenuCategoryId(id);
        return GenericResponse.ok(menuItemByMenuCategory);
    }




}
