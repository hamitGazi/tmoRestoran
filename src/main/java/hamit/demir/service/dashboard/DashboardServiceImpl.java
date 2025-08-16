package hamit.demir.service.dashboard;

import hamit.demir.model.dto.dashboard.DashboardOzetResponse;
import hamit.demir.model.dto.dashboard.SiparisDurumGrafikResponse;
import hamit.demir.repository.dashboard.DashboardRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {


    private final DashboardRepositoryCustom dashboardRepository;
@Override
public DashboardOzetResponse getOzet() {
        return dashboardRepository.fetchOzet();
    }
@Override
public List<SiparisDurumGrafikResponse> getSiparisDurumGrafik() {
        return dashboardRepository.fetchSiparisDurumGrafik();
    }
}


