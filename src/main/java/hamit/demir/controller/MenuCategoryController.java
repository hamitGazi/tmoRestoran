package hamit.demir.controller;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import hamit.demir.repository.menuCategory.MenuCategoryRepository;
import hamit.demir.service.MasaService;
import hamit.demir.service.menuCategory.MenuCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu-category")
@RequiredArgsConstructor
public class MenuCategoryController {

     private final MenuCategoryService menuCategoryService;

    @GetMapping
    public List<MenuCategoryResponse> getAllMenuCategories() {
        return menuCategoryService.getAllMenuCategory();
    }

    @GetMapping("/{id}")
    public MenuCategoryResponse getMenuCategory(@PathVariable Long id) {
        return menuCategoryService.getMenuCategoryById(id);
    }

    @PostMapping
    public Long saveMenuCategory(@Valid @RequestBody MenuCategorySaveRequest request) {
        return menuCategoryService.saveMenuCategory(request);
    }

    @PutMapping
    public Long update(@Valid @RequestBody MenuCategoryUpdateRequest request) {
        return menuCategoryService.updateMenuCategory(request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return menuCategoryService.deleteMenuCategory(id);
    }

}
