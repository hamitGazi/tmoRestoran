package hamit.demir.repository.menuFiyat;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;

import java.util.List;

public interface MenuFiyatRepositoryCustom {

    List<MenuFiyatResponse> fetchAllMenuFiyatList();

    MenuFiyatResponse fetchMenuFiyatById(Long id);
}
