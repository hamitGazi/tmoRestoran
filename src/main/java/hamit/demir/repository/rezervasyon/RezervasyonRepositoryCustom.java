package hamit.demir.repository.rezervasyon;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.entity.MenuFiyatEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface RezervasyonRepositoryCustom {


    List<RezervasyonResponse> fetchAllRezervasyonlar();

    RezervasyonResponse fetchRezervasyonById(Long id);
}
