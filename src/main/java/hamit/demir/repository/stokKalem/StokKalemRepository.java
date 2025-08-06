package hamit.demir.repository.stokKalem;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.StokKalemiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokKalemRepository extends JpaRepository<StokKalemiEntity, Long>, StokKalemRepositoryCustom {


}
