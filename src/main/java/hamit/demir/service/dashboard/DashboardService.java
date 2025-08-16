package hamit.demir.service.dashboard;

import hamit.demir.model.dto.dashboard.DashboardOzetResponse;
import hamit.demir.model.dto.dashboard.SiparisDurumGrafikResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuFiyat.MenuFiyatSaveRequest;
import hamit.demir.model.dto.menuFiyat.MenuFiyatUpdateRequest;

import java.util.List;

public interface DashboardService {


    DashboardOzetResponse getOzet();

    List<SiparisDurumGrafikResponse> getSiparisDurumGrafik();
}
