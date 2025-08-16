package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterRequest;
import hamit.demir.model.dto.raporlar.satisRapor.SatisRaporFilterResponse;
import hamit.demir.repository.raporlar.SatisRaporRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SatisRaporServiceImpl implements SatisRaporService {

    private final SatisRaporRepository satisRepository;

    @Override
    public List<SatisRaporFilterResponse> getSatisRaporlari(SatisRaporFilterRequest filter) {
        return satisRepository.fetchSatisRaporlari(filter);
    }


}