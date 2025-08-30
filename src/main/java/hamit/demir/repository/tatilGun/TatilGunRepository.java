package hamit.demir.repository.tatilGun;

import hamit.demir.model.entity.TatilGunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TatilGunRepository extends JpaRepository<TatilGunEntity,Long>, TatilGunRepositoryCustom {
}
