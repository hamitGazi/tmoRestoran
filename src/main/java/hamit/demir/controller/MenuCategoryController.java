package hamit.demir.controller;

import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import hamit.demir.service.menuCategory.MenuCategoryService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("menu-category")
@RequiredArgsConstructor
public class MenuCategoryController {
    private final MenuCategoryService menuCategoryService;

    @GetMapping("all")
    public GenericRespose<List<MenuCategoryResponse>> getAllMenuCategories() {
        List<MenuCategoryResponse> allMenuCategory = menuCategoryService.getAllMenuCategory();
        return GenericRespose.ok(allMenuCategory);
    }

    @GetMapping("/{id}")
    public GenericRespose<MenuCategoryResponse> getMenuCategory(@PathVariable Long id) {
        MenuCategoryResponse menuCategoryById = menuCategoryService.getMenuCategoryById(id);
        return GenericRespose.ok(menuCategoryById);

    }

    @PostMapping("save")
    public GenericRespose<Long> saveMenuCategory(@Valid @RequestBody MenuCategorySaveRequest request) {
        Long id = menuCategoryService.saveMenuCategory(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> update(@Valid @RequestBody MenuCategoryUpdateRequest request) {
        Long id = menuCategoryService.updateMenuCategory(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericRespose<String> delete(@PathVariable Long id) {
        String str = menuCategoryService.deleteMenuCategory(id);
        return GenericRespose.ok(str);

    }

}
