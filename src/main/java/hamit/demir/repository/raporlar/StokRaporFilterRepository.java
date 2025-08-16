package hamit.demir.repository.raporlar;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.StokKalemiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokRaporFilterRepository extends JpaRepository<StokKalemiEntity, Long>, StokRaporFilterRepositoryCustom {


}
