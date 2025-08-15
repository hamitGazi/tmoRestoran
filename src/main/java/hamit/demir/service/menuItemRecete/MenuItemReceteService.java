package hamit.demir.service.menuItemRecete;

import hamit.demir.model.dto.menuItem.MenuItemByCategoryIdResponse;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteResponse;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteSaveRequest;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteUpdateRequest;
import hamit.demir.utils.GenericResponse;

import java.util.List;

public interface MenuItemReceteService {


    List<MenuItemReceteResponse> getAllReceteler();

    MenuItemReceteResponse getReceteById(Long id);

    List<MenuItemReceteResponse> getRecetelerByMenuUrunId(Long menuUrunId);




    Long updateRecete(MenuItemReceteUpdateRequest request);


    String deleteRecete(Long id);

    Long saveRecete(MenuItemReceteSaveRequest requests);


    List<MenuItemReceteResponse> getSiraliReceteKalemByMenuUrunId(Long id);
}
