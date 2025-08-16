package hamit.demir.repository.raporlar;

import hamit.demir.model.entity.MasaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasaKullanimRaporRepository extends JpaRepository<MasaEntity, Long>, MasaKullanimRaporRepositoryCustom {


}
