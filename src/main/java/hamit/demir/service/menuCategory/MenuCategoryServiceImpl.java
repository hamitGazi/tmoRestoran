package hamit.demir.service.menuCategory;

import hamit.demir.model.dto.masaCategory.MenuCategoryResponse;
import hamit.demir.model.dto.masaCategory.MenuCategorySaveRequest;
import hamit.demir.model.dto.masaCategory.MenuCategoryUpdateRequest;
import hamit.demir.model.entity.MenuCategoryEntity;
import hamit.demir.repository.menuCategory.MenuCategoryRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryServiceImpl implements MenuCategoryService {

    private final MenuCategoryRepository repository;

    public MenuCategoryResponse getMenuCategoryById(Long id) {

       return repository.fetchMenuCategoryById(id);
    }

    @Override
    public Long saveMenuCategory(MenuCategorySaveRequest request) {
        MenuCategoryEntity menuCategory = new MenuCategoryEntity();
        menuCategory.setAd(request.ad());
        menuCategory.setAciklama(request.aciklama());
        menuCategory.setMenuSira(request.menuSira());
        menuCategory.setAktif(request.aktif());
        menuCategory.setOlusturmaTarih(LocalDateTime.now());
        return repository.save(menuCategory).getId();

    }

    @Override
    public Long updateMenuCategory(MenuCategoryUpdateRequest request) {
        MenuCategoryEntity menuCategory = repository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("MenuCategory Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        menuCategory.setAd(request.ad());
        menuCategory.setAciklama(request.aciklama());
        menuCategory.setMenuSira(request.menuSira());
        menuCategory.setAktif(request.aktif());
        menuCategory.setGuncelemeTarih(LocalDateTime.now());
        return repository.save(menuCategory).getId();
    }

    @Override
    public String deleteMenuCategory(Long id) {
        MenuCategoryEntity menuCategory = repository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("MenuCategory Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        repository.deleteById(menuCategory.getId());
        return "Silme işlemi başarılı";
    }





    @Override
    public List<MenuCategoryResponse> getAllMenuCategory() {
        return repository.fetchAllMenuCategory();
    }
}
