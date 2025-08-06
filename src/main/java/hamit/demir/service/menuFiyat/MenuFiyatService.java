package hamit.demir.service.menuFiyat;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface MenuFiyatService {



    MenuFiyatResponse getMenuFiyatById(Long id);

    Long saveMenuFiyat(MenuFiyatSaveRequest request);

    Long updateMenuFiyat(MenuFiyatUpdateRequest request);

    String deleteMenuFiyat(Long id);

    List<MenuFiyatResponse> getAllMenuFiyatList();
}
