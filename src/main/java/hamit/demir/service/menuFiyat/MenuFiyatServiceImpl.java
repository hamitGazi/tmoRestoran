package hamit.demir.service.menuFiyat;

import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import hamit.demir.model.entity.MenuFiyatEntity;
import hamit.demir.repository.menuFiyat.MenuFiyatRepository;
import hamit.demir.repository.menuItem.MenuItemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericRespose;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuFiyatServiceImpl implements MenuFiyatService {

    private final MenuFiyatRepository menuFiyatRepository;
    private final MenuItemRepository menuItemRepository;



    @Override
    public MenuFiyatResponse getMenuFiyatById(Long id) {
        return menuFiyatRepository.fetchMenuFiyatById(id);
    }

    @Override
    public Long saveMenuFiyat(MenuFiyatSaveRequest request) {
        MenuFiyatEntity entity = new MenuFiyatEntity();
       entity.setMenuItem(menuItemRepository.getReferenceById(request.menuItemId()));
       entity.setFiyat(request.fiyat());
       entity.setIndirimFiyati(request.indirimFiyati());
       entity.setGecerlilikBaslangic(request.gecerlilikBaslangic());
       entity.setGecerlilikBitis(request.gecerlilikBitis());
       entity.setAktif(request.aktif());

        return menuFiyatRepository.save(entity).getId();
    }

    @Override
    public Long updateMenuFiyat(MenuFiyatUpdateRequest request) {
        MenuFiyatEntity entity = menuFiyatRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("MenuFiyat Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        entity.setFiyat(request.fiyat());
        entity.setIndirimFiyati(request.indirimFiyati());
        entity.setGecerlilikBaslangic(request.gecerlilikBaslangic());
        entity.setGecerlilikBitis(request.gecerlilikBitis());
        entity.setAktif(request.aktif());
        return menuFiyatRepository.save(entity).getId();
    }

    @Override
    public String deleteMenuFiyat(Long id) {
        MenuFiyatEntity entity = menuFiyatRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("MenuFiyat Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        menuFiyatRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

    @Override
    public List<MenuFiyatResponse> getAllMenuFiyatList() {
        return menuFiyatRepository.fetchAllMenuFiyatList();
    }

}
