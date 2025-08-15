package hamit.demir.controller;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteResponse;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteSaveRequest;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteUpdateRequest;
import hamit.demir.model.entity.Birim;
import hamit.demir.service.menuItemRecete.MenuItemReceteService;
import hamit.demir.utils.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("menu-item-recete")
@RequiredArgsConstructor
public class MenuItemReceteController {

    private final MenuItemReceteService menuItemReceteService;
    @GetMapping("birim-enum")
    public GenericResponse<List<EnumRecord>> getAllBirimEnum() {
        List<EnumRecord> enumRecords = Birim.birimEnumList();
        return  GenericResponse.ok(enumRecords);
    }

    @GetMapping("all")
    public GenericResponse<List<MenuItemReceteResponse>> getAllReceteler() {
        List<MenuItemReceteResponse> receteler = menuItemReceteService.getAllReceteler();
        return GenericResponse.ok(receteler);
    }

    @GetMapping("by-menu-urun/sirali/{id}")

    public GenericResponse<List<MenuItemReceteResponse>> getSiraliReceteKalemByMenuUrunId(@PathVariable Long id) {

         List<MenuItemReceteResponse> siraliKalem=menuItemReceteService.getSiraliReceteKalemByMenuUrunId(id);
        return GenericResponse.ok(siraliKalem);

    }
    @GetMapping("/{id}")
    public GenericResponse<MenuItemReceteResponse> getReceteById(@PathVariable Long id) {
        MenuItemReceteResponse recete = menuItemReceteService.getReceteById(id);
        return GenericResponse.ok(recete);
    }

    @GetMapping("by-menu-urun/{menuUrunId}")
    public GenericResponse<List<MenuItemReceteResponse>> getRecetelerByMenuUrunId(@PathVariable Long menuUrunId) {
        List<MenuItemReceteResponse> receteler = menuItemReceteService.getRecetelerByMenuUrunId(menuUrunId);
        return GenericResponse.ok(receteler);
    }

    @PostMapping("save")
    public  GenericResponse<Long>saveRecete(@Valid @RequestBody MenuItemReceteSaveRequest request) {
       Long id= menuItemReceteService.saveRecete(request);
        return GenericResponse.ok(id);
    }

    @PutMapping("update")
    public GenericResponse<Long> updateRecete(@Valid @RequestBody MenuItemReceteUpdateRequest request) {
        Long id = menuItemReceteService.updateRecete(request);
        return GenericResponse.ok(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteRecete(@PathVariable Long id) {
        String result = menuItemReceteService.deleteRecete(id);
        return GenericResponse.ok(result);
    }
}
