package hamit.demir.repository.rezervasyonSureAyar;


import hamit.demir.model.entity.RezervasyonSureAyarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervasyonSureAyarRepository extends JpaRepository<RezervasyonSureAyarEntity, Long>, RezervasyonSureAyarRepositoryCustom {


}
