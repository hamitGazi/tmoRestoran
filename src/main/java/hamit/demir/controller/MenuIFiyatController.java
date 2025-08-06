package hamit.demir.controller;

import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import hamit.demir.model.dto.menuItem.MenuItemResponse;
import hamit.demir.model.dto.menuItem.MenuItemSaveRequest;
import hamit.demir.model.dto.menuItem.MenuItemUpdateRequest;
import hamit.demir.service.menuFiyat.MenuFiyatService;
import hamit.demir.service.menuItem.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu-fiyat")
@RequiredArgsConstructor
public class MenuIFiyatController {
    private final MenuFiyatService menuFiyatService;

    @GetMapping
    public List<MenuFiyatResponse> getAllMenuFiyat() {
        return menuFiyatService.getAllMenuFiyatList();
    }

    @GetMapping("/{id}")
    public MenuFiyatResponse getMenuFiyatById(@PathVariable Long id) {
        return menuFiyatService.getMenuFiyatById(id);
    }

    @PostMapping
    public Long saveMenuFiyat(@Valid @RequestBody MenuFiyatSaveRequest request) {
        return menuFiyatService.saveMenuFiyat(request);
    }

    @PutMapping
    public Long updateMenuItem(@Valid @RequestBody MenuFiyatUpdateRequest request) {
        return menuFiyatService.updateMenuFiyat(request);
    }

    @DeleteMapping("/{id}")
    public String deleteMenuFiyat(@PathVariable Long id) {
        return menuFiyatService.deleteMenuFiyat(id);
    }


}
