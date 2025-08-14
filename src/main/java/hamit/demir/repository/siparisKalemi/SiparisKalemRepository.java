package hamit.demir.repository.siparisKalemi;

import hamit.demir.model.entity.SiparisKalemiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiparisKalemRepository extends JpaRepository<SiparisKalemiEntity, Long>, SiparisKalemRepositoryCustom {


    List<SiparisKalemiEntity> findBySiparisId(Long siparisId);
}
