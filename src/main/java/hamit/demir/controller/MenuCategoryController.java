package hamit.demir.controller;

import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import hamit.demir.service.menuCategory.MenuCategoryService;
import hamit.demir.utils.GenericResponse;
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
    public GenericResponse<List<MenuCategoryResponse>> getAllMenuCategories() {
        List<MenuCategoryResponse> allMenuCategory = menuCategoryService.getAllMenuCategory();
        return GenericResponse.ok(allMenuCategory);
    }

    @GetMapping("/{id}")
    public GenericResponse<MenuCategoryResponse> getMenuCategory(@PathVariable Long id) {
        MenuCategoryResponse menuCategoryById = menuCategoryService.getMenuCategoryById(id);
        return GenericResponse.ok(menuCategoryById);

    }

    @PostMapping("save")
    public GenericResponse<Long> saveMenuCategory(@Valid @RequestBody MenuCategorySaveRequest request) {
        Long id = menuCategoryService.saveMenuCategory(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> update(@Valid @RequestBody MenuCategoryUpdateRequest request) {
        Long id = menuCategoryService.updateMenuCategory(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> delete(@PathVariable Long id) {
        String str = menuCategoryService.deleteMenuCategory(id);
        return GenericResponse.ok(str);

    }

}
