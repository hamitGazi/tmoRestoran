package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.stokKalem.StokKalemRaporResponse;
import hamit.demir.model.dto.raporlar.stokKalem.StokRaporFilterRequest;
import hamit.demir.repository.raporlar.StokKalemRaporFilterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StokKalemRaporServiceImpl implements StokKalemRaporService {

    private final StokKalemRaporFilterRepository stokRepository;

    @Override
    public List<StokKalemRaporResponse> getStokRaporlari(StokRaporFilterRequest filter) {
        return stokRepository.fetchStokRaporlari(filter);
    }


}