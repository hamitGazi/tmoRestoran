package hamit.demir.service.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.MasaKullanimRaporFilterResponse;
import hamit.demir.model.entity.MasaKonum;
import hamit.demir.repository.raporlar.MasaKullanimRaporRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MasaKullanimRaporServiceImpl implements MasaKullanimRaporService {

    private final MasaKullanimRaporRepository raporRepository;

    @Override
    public List<MasaKullanimRaporFilterResponse> getMasaKullanimRaporlari(MasaKullanimRaporFilterResponse filter) {
        return raporRepository.fetchMasaKullanimRaporlari(filter);
    }

}