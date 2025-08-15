package hamit.demir.repository.stokHareket;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.entity.MenuFiyatEntity;
import hamit.demir.model.entity.StokKalemiEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface StokHareketRepositoryCustom {


    Long fethStokKalemByHareket(Long id);
}
