package hamit.demir.service.menuCategory;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface MenuCategoryService {



    List<MenuCategoryResponse> getAllMenuCategory();

    MenuCategoryResponse getMenuCategoryById(Long id);

    Long saveMenuCategory(MenuCategorySaveRequest category);

    Long updateMenuCategory(MenuCategoryUpdateRequest request);

    String deleteMenuCategory(Long id);


}
