package hamit.demir.repository.musteri;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MusteriEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusteriRepository extends JpaRepository<MusteriEntity, Long>, MusteriRepositoryCustom {


}
