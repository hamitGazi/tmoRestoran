package hamit.demir.repository.musteriGeriBildirim;

import hamit.demir.model.entity.MusteriGeriBildirimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusteriGeriBildirimRepository extends JpaRepository<MusteriGeriBildirimEntity, Long>, MusteriGeriBildirimRepositoryCustom {


}
