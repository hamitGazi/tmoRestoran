package hamit.demir.controller;

import hamit.demir.model.dto.menuFiyat.MenuFiyatResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import hamit.demir.service.menuFiyat.MenuFiyatService;
import hamit.demir.utils.GenericRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("menu-fiyat")
@RequiredArgsConstructor
public class MenuIFiyatController {
    private final MenuFiyatService menuFiyatService;

    @GetMapping("all")
    public GenericRespose<List<MenuFiyatResponse>> getAllMenuFiyat() {
        List<MenuFiyatResponse> allMenuFiyatList = menuFiyatService.getAllMenuFiyatList();
        return GenericRespose.ok(allMenuFiyatList);
    }
    @GetMapping("/{id}")
    public GenericRespose<MenuFiyatResponse> getMenuFiyatById(@PathVariable Long id) {
        MenuFiyatResponse menuFiyatById = menuFiyatService.getMenuFiyatById(id);
        return GenericRespose.ok(menuFiyatById);
    }
    @PostMapping("save")
    public GenericRespose<Long> saveMenuFiyat(@Valid @RequestBody MenuFiyatSaveRequest request) {

        Long id = menuFiyatService.saveMenuFiyat(request);
        return GenericRespose.ok(id);
    }

    @PutMapping("update")
    public GenericRespose<Long> updateMenuItem(@Valid @RequestBody MenuFiyatUpdateRequest request) {

        Long id = menuFiyatService.updateMenuFiyat(request);
        return GenericRespose.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericRespose<String> deleteMenuFiyat(@PathVariable Long id) {

        String str = menuFiyatService.deleteMenuFiyat(id);
        return GenericRespose.ok(str);


    }


}
