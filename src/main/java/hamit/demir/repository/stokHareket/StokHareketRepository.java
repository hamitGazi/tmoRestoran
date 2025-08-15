package hamit.demir.repository.stokHareket;

import hamit.demir.model.entity.MenuFiyatEntity;
import hamit.demir.model.entity.StokHareketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokHareketRepository extends JpaRepository<StokHareketEntity, Long>, StokHareketRepositoryCustom {


}
