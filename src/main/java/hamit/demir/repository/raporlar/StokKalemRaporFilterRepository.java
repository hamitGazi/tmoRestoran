package hamit.demir.repository.raporlar;

import hamit.demir.model.entity.StokKalemiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokKalemRaporFilterRepository extends JpaRepository<StokKalemiEntity, Long>, StokKalemRaporFilterRepositoryCustom {


}
