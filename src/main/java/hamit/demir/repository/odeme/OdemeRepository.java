package hamit.demir.repository.odeme;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.OdemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdemeRepository extends JpaRepository<OdemeEntity, Long>, OdemeRepositoryCustom {


}
