package hamit.demir.repository.dashboard;

import hamit.demir.model.dto.dashboard.DashboardOzetResponse;
import hamit.demir.model.dto.dashboard.SiparisDurumGrafikResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.entity.MenuFiyatEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface DashboardRepositoryCustom {


    DashboardOzetResponse fetchOzet();

    List<SiparisDurumGrafikResponse> fetchSiparisDurumGrafik();
}
