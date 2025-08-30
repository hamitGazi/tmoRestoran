package hamit.demir.service.calismaZaman;

import hamit.demir.model.dto.calisZaman.CalismaZamanResponse;
import hamit.demir.model.dto.calisZaman.CalismaZamanSaveRequest;
import hamit.demir.model.dto.calisZaman.CalismaZamanUpdateRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface CalismaZamanService {


    List<CalismaZamanResponse> getAllCalismaZamanlar();

    CalismaZamanResponse getCalismaZamanById(Long id);

    Long saveCalismaZaman(CalismaZamanSaveRequest request);

    Long updateCalismaZaman(CalismaZamanUpdateRequest request);

    String deleteCalismaZamanById(Long id);

    Boolean UygunZaman(LocalDateTime dateTime);

    List<CalismaZamanResponse> getAktifIstisnaZaman();
}
