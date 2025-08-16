package hamit.demir.repository.dashboard;

import hamit.demir.model.entity.MenuFiyatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<MenuFiyatEntity, Long>, DashboardRepositoryCustom {


}
