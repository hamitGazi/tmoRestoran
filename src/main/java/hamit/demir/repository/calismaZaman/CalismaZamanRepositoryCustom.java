package hamit.demir.repository.calismaZaman;

import hamit.demir.model.dto.calisZaman.CalismaZamanResponse;
import hamit.demir.model.dto.calisZaman.CalismaZamanSaveRequest;
import hamit.demir.model.dto.calisZaman.CalismaZamanUpdateRequest;
import hamit.demir.model.entity.CalismaGunEnum;
import hamit.demir.model.entity.CalismaZamanEntity;

import java.util.List;

public interface CalismaZamanRepositoryCustom {


    List<CalismaZamanResponse> fetchAllCalismaZamanlar();



    CalismaZamanResponse fetchCalismaZamanById(Long id);

    CalismaZamanEntity fetchGecerliCalismaZaman(CalismaGunEnum gun);

    List<CalismaZamanResponse> fetchAktifIstisnaZaman();
}
