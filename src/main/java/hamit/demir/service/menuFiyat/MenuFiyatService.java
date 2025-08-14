package hamit.demir.service.menuFiyat;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;

import java.util.List;

public interface MenuFiyatService {



    MenuFiyatAllResponse getMenuFiyatById(Long id);

    Long saveMenuFiyat(MenuFiyatSaveRequest request);

    Long updateMenuFiyat(MenuFiyatUpdateRequest request);

    String deleteMenuFiyat(Long id);

    List<MenuFiyatAllResponse> getAllMenuFiyatList();
}
