package hamit.demir.repository.menuFiyat;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MenuFiyatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuFiyatRepository extends JpaRepository<MenuFiyatEntity, Long>, MenuFiyatRepositoryCustom {


}
