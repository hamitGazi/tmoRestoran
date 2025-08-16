package hamit.demir.controller;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import hamit.demir.service.menuFiyat.MenuFiyatService;
import hamit.demir.utils.GenericResponse;
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
    public GenericResponse<List<MenuFiyatAllResponse>> getAllMenuFiyat() {
        List<MenuFiyatAllResponse> allMenuFiyatList = menuFiyatService.getAllMenuFiyatList();
        return GenericResponse.ok(allMenuFiyatList);
    }
    @GetMapping("/{id}")
    public GenericResponse<MenuFiyatAllResponse> getMenuFiyatById(@PathVariable Long id) {
        MenuFiyatAllResponse menuFiyatById = menuFiyatService.getMenuFiyatById(id);
        return GenericResponse.ok(menuFiyatById);
    }
    @PostMapping("save")
    public GenericResponse<Long> saveMenuFiyat(@Valid @RequestBody MenuFiyatSaveRequest request) {

        Long id = menuFiyatService.saveMenuFiyat(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateMenuItem(@Valid @RequestBody MenuFiyatUpdateRequest request) {

        Long id = menuFiyatService.updateMenuFiyat(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<String> deleteMenuFiyat(@PathVariable Long id) {

        String str = menuFiyatService.deleteMenuFiyat(id);
        return GenericResponse.ok(str);


    }


}
