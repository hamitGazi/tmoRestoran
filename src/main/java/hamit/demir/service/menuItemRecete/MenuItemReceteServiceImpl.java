package hamit.demir.service.menuItemRecete;

import hamit.demir.model.dto.menuItemRecete.MenuItemReceteResponse;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteSaveRequest;
import hamit.demir.model.dto.menuItemRecete.MenuItemReceteUpdateRequest;
import hamit.demir.model.entity.MenuItemReceteEntity;
import hamit.demir.repository.menuItem.MenuItemRepository;
import hamit.demir.repository.menuItemRecete.MenuItemReceteRepository;
import hamit.demir.repository.stokKalem.StokKalemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuItemReceteServiceImpl implements MenuItemReceteService {


    private final MenuItemReceteRepository menuItemReceteRepository;
    private final MenuItemRepository menuItemRepository;
    private final StokKalemRepository stokKalemRepository;

    @Override
    public List<MenuItemReceteResponse> getAllReceteler() {
        return menuItemReceteRepository.fetchAllReceteler();
    }

    @Override
    public MenuItemReceteResponse getReceteById(Long id) {
        return  menuItemReceteRepository.fetchReceteById(id);

    }

    @Override
    public List<MenuItemReceteResponse> getRecetelerByMenuUrunId(Long menuUrunId) {
        return menuItemReceteRepository.fetchRecetelerByMenuUrunId(menuUrunId);
    }


    @Override
    public String deleteRecete(Long id) {
        MenuItemReceteEntity entity = menuItemReceteRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Reçete bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        menuItemReceteRepository.deleteById(id);
        return "Reçete silme işlemi başarılı";
    }


    @Override
    public Long saveRecete(MenuItemReceteSaveRequest request) {


        MenuItemReceteEntity receteEntity = new MenuItemReceteEntity();
        receteEntity.setMenuUrun(menuItemRepository.getReferenceById(request.menuUrunId()));
        receteEntity.setStokKalemi(stokKalemRepository.getReferenceById(request.stokKalemiId()));
        receteEntity.setMiktar(request.miktar());
        receteEntity.setBirim(request.birim());
        receteEntity.setOlusturmaTarih(LocalDateTime.now());

        return menuItemReceteRepository.save(receteEntity).getId();

    }

    @Override
    public List<MenuItemReceteResponse> getSiraliReceteKalemByMenuUrunId(Long id) {
        return  menuItemReceteRepository.fetchSiraliKalemByUrunId(id);
    }


    @Override
    public Long updateRecete(MenuItemReceteUpdateRequest request) {
        // Reçete kaydını proxy olarak al
        MenuItemReceteEntity recete = menuItemReceteRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("MenuItem Reçete Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        //
        recete.setMenuUrun(menuItemRepository.getReferenceById(request.menuUrunId()));
        recete.setStokKalemi(stokKalemRepository.getReferenceById(request.stokKalemiId()));
        recete.setMiktar(request.miktar());
        recete.setBirim(request.birim());
        recete.setGuncelleTarih(LocalDateTime.now());

        MenuItemReceteEntity updatedRecete = menuItemReceteRepository.save(recete);
        return updatedRecete.getId();
    }
}
