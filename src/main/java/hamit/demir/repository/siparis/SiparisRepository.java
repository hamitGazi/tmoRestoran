package hamit.demir.repository.siparis;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.SiparisEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiparisRepository extends JpaRepository<SiparisEntity, Long>, SiparisRepositoryCustom {


    boolean existsByIdAndOdeme_OdemeDurum( Long id, OdemeDurumu odemeDurumu);
}
