package hamit.demir.repository.menuFiyat;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.entity.MenuFiyatEntity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface MenuFiyatRepositoryCustom {

    List<MenuFiyatAllResponse> fetchAllMenuFiyatList();

    MenuFiyatAllResponse fetchMenuFiyatById(Long id);

    List<MenuFiyatEntity> fetMenuFiyatInIds(List<Long> itemIds, LocalDateTime now);

    BigDecimal fetchMenuItemFiyat(Long menuItemId);
}
