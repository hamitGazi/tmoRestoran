package hamit.demir.repository.menuCategory;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MenuCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository<MenuCategoryEntity, Long>, MenuCategoryRepositoryCustom {


}
