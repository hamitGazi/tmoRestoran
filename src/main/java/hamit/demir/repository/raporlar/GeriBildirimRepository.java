package hamit.demir.repository.raporlar;

import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.MusteriGeriBildirimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeriBildirimRepository extends JpaRepository<MusteriGeriBildirimEntity, Long>, GeriBildirimRepositoryCustom {


}
