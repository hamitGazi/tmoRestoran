package hamit.demir.controller.dashboard;

import hamit.demir.model.dto.dashboard.DashboardOzetResponse;
import hamit.demir.model.dto.dashboard.SiparisDurumGrafikResponse;
import hamit.demir.service.dashboard.DashboardService;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/ozet")
    public GenericResponse<DashboardOzetResponse> getOzet() {
        return GenericResponse.ok(dashboardService.getOzet());
    }

    @GetMapping("/siparis-durum-grafik")
    public GenericResponse<List<SiparisDurumGrafikResponse>> getSiparisDurumGrafik() {
        return GenericResponse.ok(dashboardService.getSiparisDurumGrafik());
    }
}