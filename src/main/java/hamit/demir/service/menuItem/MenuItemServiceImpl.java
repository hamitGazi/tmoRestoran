package hamit.demir.service.menuItem;

import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import hamit.demir.model.entity.MenuItemEntity;
import hamit.demir.repository.menuCategory.MenuCategoryRepository;
import hamit.demir.repository.menuItem.MenuItemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericRespose;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuCategoryRepository menuCategoryRepository;

    @Override
    public List<MenuItemResponse> getAllMenuItems() {
        return menuItemRepository.fetchAllMenuItems();
    }

    @Override
    public MenuItemResponse getMenuItemById(Long id) {
        return menuItemRepository.fetchMenuItemById(id);
    }

    @Override
    public Long saveMenuItem(MenuItemSaveRequest request) {
        MenuItemEntity entity = new MenuItemEntity();
        entity.setAd(request.ad());
        entity.setAciklama(request.aciklama());
        entity.setKategori(menuCategoryRepository.getReferenceById(request.kategoriId()));
        entity.setAktif(request.aktif());
        entity.setResimYolu(request.resimYolu());
        entity.setEkOzellikler(request.ekOzellikler());
        entity.setOlusturmaTarih(LocalDateTime.now());
        return menuItemRepository.save(entity).getId();
    }

    @Override
    public Long updateMenuItem(MenuItemUpdateRequest request) {
        MenuItemEntity entity = menuItemRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("MenuItem Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        entity.setAd(request.ad());
        entity.setAciklama(request.aciklama());
        entity.setKategori(menuCategoryRepository.getReferenceById(request.kategoriId()));
        entity.setAktif(request.aktif());
        entity.setResimYolu(request.resimYolu());
        entity.setEkOzellikler(request.ekOzellikler());
        entity.setGuncelemeTarih(LocalDateTime.now());
        return menuItemRepository.save(entity).getId();
    }

    @Override
    public String deleteMenuItem(Long id) {
        MenuItemEntity entity = menuItemRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericRespose.error("MenuItem Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        menuItemRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

}
