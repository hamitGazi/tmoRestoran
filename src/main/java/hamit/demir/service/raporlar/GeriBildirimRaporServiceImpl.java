package hamit.demir.service.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.GeriBildirimRaporFilterResponse;
import hamit.demir.model.entity.GeriBildirimTuruEnum;
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
    public List<GeriBildirimRaporFilterResponse> getGeriBildirimRaporlari(GeriBildirimRaporFilterResponse filter) {
        return geriBildirimRepository.fetchGeriBildirimRaporlari(filter);
    }

    @Override
    public List<EnumRecord> getGeriBildirimTurEnum() {
        return GeriBildirimTuruEnum.geriBildirimListesi();
    }
}