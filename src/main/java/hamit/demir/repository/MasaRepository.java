package hamit.demir.repository;

import hamit.demir.model.entity.MasaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasaRepository extends JpaRepository<MasaEntity, Long>, MasaRepositoryCustom {


}
