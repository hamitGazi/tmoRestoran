package hamit.demir.service.stokKalemi;

import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.StokKalemi.StokKalemiSaveRequest;
import hamit.demir.model.dto.StokKalemi.StokKalemiUpdateRequest;
import hamit.demir.model.entity.StokKalemiEntity;
import hamit.demir.repository.stokKalem.StokKalemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StokKalemServiceImpl implements StokKalemService {

    private final StokKalemRepository stokKalemRepository;

    @Override
    public List<StokKalemiResponse> getAllStokKalemler() {
        return stokKalemRepository.fetchAllStokKalemler();
    }

    @Override
    public StokKalemiResponse getStokKalemById(Long id) {
        return stokKalemRepository.fetchStokKalemById(id);
    }

    @Override
    public Long saveStokKalem(StokKalemiSaveRequest request) {
        StokKalemiEntity entity = new StokKalemiEntity();
        entity.setAd(request.ad());
        entity.setMiktar(request.miktar());
        entity.setBirim(request.birim());
        entity.setAktif(request.aktif());
        entity.setOlusturmaTarih(LocalDateTime.now());

        return stokKalemRepository.save(entity).getId();
    }

    @Override
    public Long updateStokKalem(StokKalemiUpdateRequest request) {
        StokKalemiEntity entity = stokKalemRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("StokKalemi Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        entity.setAd(request.ad());
        entity.setMiktar(request.miktar());
        entity.setBirim(request.birim());
        entity.setAktif(request.aktif());
        entity.setOlusturmaTarih(LocalDateTime.now());
        return stokKalemRepository.save(entity).getId();
    }


}
