package hamit.demir.repository.rezervasyon;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.entity.MenuFiyatEntity;
import hamit.demir.model.entity.RezervasyonDurum;
import hamit.demir.model.entity.RezervasyonEntity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface RezervasyonRepositoryCustom {


    List<RezervasyonResponse> fetchAllRezervasyonlar();

    List<RezervasyonEntity> fetchMevcutRezervasyonHaricCakisanMevcutRezervasyonlar(
            Long masaId,
            LocalDateTime yeniBaslangic,
            LocalDateTime yeniBitis,
            Long rezervasyonId
    );

    RezervasyonResponse fetchRezervasyonById(Long id);

    List<RezervasyonEntity> fetchCakisanRezervasyonlar(Long id, LocalDateTime yeniBaslangic, LocalDateTime yeniBitis);

    List<RezervasyonEntity> fetchByDurum(RezervasyonDurum rezervasyonDurum);
}
