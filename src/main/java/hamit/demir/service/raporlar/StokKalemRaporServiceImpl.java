package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.StokRaporFilterResponse;
import hamit.demir.repository.stokKalem.StokKalemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StokKalemRaporServiceImpl implements StokKalemRaporService {

    private final StokKalemRepository stokRepository;

    @Override
    public List<StokRaporFilterResponse> getStokRaporlari(StokRaporFilterResponse filter) {
        return stokRepository.fetchStokRaporlari(filter);
    }


}