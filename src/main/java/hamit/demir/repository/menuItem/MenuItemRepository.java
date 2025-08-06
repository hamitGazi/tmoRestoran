package hamit.demir.repository.menuItem;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long>, MenuItemRepositoryCustom {


}
