package hamit.demir.repository.personel;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.PersonelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<PersonelEntity, Long>, PersonelRepositoryCustom {


}
