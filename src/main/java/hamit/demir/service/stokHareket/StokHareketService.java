package hamit.demir.service.stokHareket;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import hamit.demir.model.entity.IslemTipEnum;

import java.math.BigDecimal;
import java.util.List;

public interface StokHareketService {


    void saveHareket(Long stokKalemiId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama);

    void updateHareket(Long hareketId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama);

    void createHareket(Long stokKalemiId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama);
}
