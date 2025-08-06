package hamit.demir.repository.menuCategory;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;

import java.util.List;

public interface MenuCategoryRepositoryCustom {



    MenuCategoryResponse fetchMenuCategoryById(long id);

    List<MenuCategoryResponse> fetchAllMenuCategory();
}
