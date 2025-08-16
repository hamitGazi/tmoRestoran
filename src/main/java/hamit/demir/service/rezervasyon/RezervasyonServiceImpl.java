package hamit.demir.service.rezervasyon;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonDeleteRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonSaveRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonUpdateRequest;
import hamit.demir.model.entity.MasaDurumu;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.RezervasyonDurum;
import hamit.demir.model.entity.RezervasyonEntity;
import hamit.demir.repository.MasaRepository;
import hamit.demir.repository.rezervasyon.RezervasyonRepository;
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
public class RezervasyonServiceImpl implements RezervasyonService {

    private final RezervasyonRepository rezervasyonRepository;
    private final MasaRepository masaRepository;

    @Override
    public List<RezervasyonResponse> getAllRezervasyonlar() {
        return rezervasyonRepository.fetchAllRezervasyonlar();
    }

    @Override
    public RezervasyonResponse getRezervasyonById(Long id) {
        return rezervasyonRepository.fetchRezervasyonById(id);
    }

    @Override
    public Long saveRezervasyon(RezervasyonSaveRequest request) {

        MasaEntity masa = masaRepository.findById(request.masaId()).orElseThrow(() ->
                new BaseException(GenericResponse.error("Rezervasyon bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        RezervasyonEntity entity = new RezervasyonEntity();
        entity.setMusteriAd(request.musteriAd());
        entity.setMasaId(masaRepository.getReferenceById(request.masaId()).getId());
        entity.setRezervasyonZamani(request.rezervasyonZamani());
        entity.setKisiSayisi(request.kisiSayisi());
        entity.setDurum(request.durum());
        entity.setOlusturmaTarih(LocalDateTime.now());
        RezervasyonEntity save = rezervasyonRepository.save(entity);
        if (save != null && save.getDurum() == RezervasyonDurum.ONAYLANDI) {
            masa.setMasaDurum(MasaDurumu.REZERVE);
            masaRepository.save(masa);
        } else {
            masa.setMasaDurum(MasaDurumu.AKTIF);
            masaRepository.save(masa);
        }
        return save.getId();
    }

    @Override
    public Long updateRezervasyon(RezervasyonUpdateRequest request) {
        RezervasyonEntity entity = rezervasyonRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Rezervasyon bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        MasaEntity masa = masaRepository.findById(request.masaId()).orElseThrow(() ->
                new BaseException(GenericResponse.error("Rezervasyon bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        entity.setMusteriAd(request.musteriAd());
        entity.setMasaId(request.masaId());
        entity.setRezervasyonZamani(request.rezervasyonZamani());
        entity.setKisiSayisi(request.kisiSayisi());
        entity.setDurum(request.durum());
        RezervasyonEntity save = rezervasyonRepository.save(entity);
        if (save != null && save.getDurum() == RezervasyonDurum.ONAYLANDI) {
            masa.setMasaDurum(MasaDurumu.REZERVE);
            masaRepository.save(masa);
        } else {
            masa.setMasaDurum(MasaDurumu.AKTIF);
            masaRepository.save(masa);
        }
        return save.getId();
    }

    @Override
    public String deleteRezervasyon( RezervasyonDeleteRequest request) {
        RezervasyonEntity entity = rezervasyonRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Rezervasyon bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        MasaEntity masa = masaRepository.findById(request.masaId()).orElseThrow(() ->
                new BaseException(GenericResponse.error("Rezervasyon bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        rezervasyonRepository.deleteById(request.id());
        masa.setMasaDurum(MasaDurumu.AKTIF);
        masaRepository.save(masa);
        return "Rezervasyon silindi.";
    }
}