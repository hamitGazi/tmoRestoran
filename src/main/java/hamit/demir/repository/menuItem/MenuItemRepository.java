package hamit.demir.repository.menuItem;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MenuItemEntity;
import hamit.demir.model.entity.MenuItemReceteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long>, MenuItemRepositoryCustom {


    List<MenuItemReceteEntity> findByMenuUrunId(Long menuUrunId);

    // Birden fazla ID ile reçete çek
    List<MenuItemReceteEntity> findByMenuUrunIdIn(List<Long> menuUrunIds);
}
