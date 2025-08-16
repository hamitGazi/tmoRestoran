package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.masaKullanim.MasaKulanimRaporFilterResponse;
import hamit.demir.model.dto.raporlar.masaKullanim.MasaKullanimRaporFilterRequest;
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
    public List<MasaKulanimRaporFilterResponse> getMasaKullanimRaporlari(MasaKullanimRaporFilterRequest filter) {
        return raporRepository.fetchMasaKullanimRaporlari(filter);
    }

}