package hamit.demir.repository.raporlar;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.PersonelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRaporRepository extends JpaRepository<PersonelEntity, Long>, PersonelRaporRepositoryCustom {


}
