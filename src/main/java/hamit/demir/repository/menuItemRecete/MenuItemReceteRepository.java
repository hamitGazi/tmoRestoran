package hamit.demir.repository.menuItemRecete;

import hamit.demir.model.entity.MenuItemReceteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemReceteRepository extends JpaRepository<MenuItemReceteEntity, Long>, MenuItemReceteRepositoryCustom {



}
