package hamit.demir.repository.siparis;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.SiparisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiparisRepository extends JpaRepository<SiparisEntity, Long>, SiparisRepositoryCustom {


}
