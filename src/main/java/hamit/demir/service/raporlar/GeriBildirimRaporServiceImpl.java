package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterRequest;
import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterResponse;
import hamit.demir.repository.raporlar.GeriBildirimRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GeriBildirimRaporServiceImpl implements GeriBildirimRaporService {

    private final GeriBildirimRepository geriBildirimRepository;

    @Override
    public List<GeriBildirimRaporFilterResponse> getGeriBildirimRaporlari(GeriBildirimRaporFilterRequest filter) {
        return geriBildirimRepository.fetchGeriBildirimRaporlari(filter);
    }



}