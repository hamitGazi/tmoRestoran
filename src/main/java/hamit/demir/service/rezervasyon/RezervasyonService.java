package hamit.demir.service.rezervasyon;

import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonDeleteRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonSaveRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonUpdateRequest;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface RezervasyonService {


    List<RezervasyonResponse> getAllRezervasyonlar();

    RezervasyonResponse getRezervasyonById(Long id);

    Long saveRezervasyon(RezervasyonSaveRequest request);

    Long updateRezervasyon(RezervasyonUpdateRequest request);

    String deleteRezervasyon(RezervasyonDeleteRequest request);




    @Scheduled(fixedRate = 60000)
    void kontrolRezervasyonScheduler();
}
