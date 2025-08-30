package hamit.demir.repository.calismaZaman;

import hamit.demir.model.entity.CalismaZamanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalismaZamanRepository extends JpaRepository<CalismaZamanEntity,Long>,CalismaZamanRepositoryCustom {
}
