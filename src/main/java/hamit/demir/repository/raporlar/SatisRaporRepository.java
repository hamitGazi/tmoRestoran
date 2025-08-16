package hamit.demir.repository.raporlar;

import hamit.demir.model.entity.SiparisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatisRaporRepository extends JpaRepository<SiparisEntity, Long>, SatisRaporRepositoryCustom {


}
