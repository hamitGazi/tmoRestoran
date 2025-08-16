package hamit.demir.repository.rezervasyon;

import hamit.demir.model.entity.MenuFiyatEntity;
import hamit.demir.model.entity.RezervasyonDurum;
import hamit.demir.model.entity.RezervasyonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervasyonRepository extends JpaRepository<RezervasyonEntity, Long>, RezervasyonRepositoryCustom {


}
