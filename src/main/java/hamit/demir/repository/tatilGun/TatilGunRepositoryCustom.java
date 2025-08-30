package hamit.demir.repository.tatilGun;

import hamit.demir.model.dto.calisZaman.CalismaZamanResponse;
import hamit.demir.model.dto.tatilGun.TatilGunResponse;
import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.model.entity.CalismaZamanEntity;
import hamit.demir.model.entity.TatilGunEntity;

import java.time.LocalDate;
import java.util.List;

public interface TatilGunRepositoryCustom {


    List<CalismaZamanResponse> fetchAllCalismaZamanlar();



    CalismaZamanResponse fetchCalismaZamanById(Long id);

    CalismaZamanEntity fetchGecerliCalismaZaman(CalismaGunEnum gun);

    List<CalismaZamanResponse> fetchAktifIstisnaZaman();

    List<TatilGunResponse> fetchAllTatilGunleri();

    TatilGunResponse fetchTatilGunById(Long id);

    List<TatilGunResponse> fetchTatilGunByCalismaZamanId(Long calismaZamanId);

    TatilGunEntity fetchGecerliTatil(LocalDate date);

    TatilGunEntity fetchGecerliTatil(LocalDate date);
}
