package hamit.demir.service.rezervasyon;

import hamit.demir.model.dto.rezervasyon.RezervasyonDeleteRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.dto.rezervasyon.RezervasyonSaveRequest;
import hamit.demir.model.dto.rezervasyon.RezervasyonUpdateRequest;
import hamit.demir.model.entity.*;
import hamit.demir.repository.MasaRepository;
import hamit.demir.repository.rezervasyon.RezervasyonRepository;
import hamit.demir.repository.rezervasyonSureAyar.RezervasyonSureAyarRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RezervasyonServiceImpl implements RezervasyonService {

    private final RezervasyonRepository rezervasyonRepository;
    private final MasaRepository masaRepository;
    private final RezervasyonSureAyarRepository rezervasyonSureAyarRepository;

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
        cakisanRezervasyonZamanKontrol(
                request.masaId(),
                request.rezervasyonZamani(),
                request.rezervasyonSuresi(),
                request.kisiSayisi(),
                request.etkinlikTip(),
                null
        );
        RezervasyonDurum durum = (request.durum() != null) ? request.durum() : RezervasyonDurum.BEKLEMEDE;
        LocalDateTime bitisZamani = request.rezervasyonZamani().plusMinutes(request.rezervasyonSuresi());
        if (bitisZamani.isAfter(LocalDateTime.now()) &&
                (durum == RezervasyonDurum.SURESI_DOLDU || durum == RezervasyonDurum.TAMAMLANDI)) {
            throw new BaseException(GenericResponse.error(
                    "Rezervasyon süresi dolmadan bu durumu set edemezsiniz!",
                    HttpStatus.BAD_REQUEST.toString()
            ));
        }
        RezervasyonEntity entity = new RezervasyonEntity();
        entity.setMusteriAd(request.musteriAd());
        entity.setMasaId(request.masaId());
        entity.setEtkinlikTip(request.etkinlikTip());
        entity.setRezervasyonZamani(request.rezervasyonZamani());
        entity.setRezervasyonSuresi(request.rezervasyonSuresi());
        entity.setKisiSayisi(request.kisiSayisi());
        entity.setDurum(durum);
        entity.setOlusturmaTarih(LocalDateTime.now());
        RezervasyonEntity saved = rezervasyonRepository.save(entity);
        updateMasaDurum(saved);
        return saved.getId();
    }

    @Override
    public Long updateRezervasyon(RezervasyonUpdateRequest request) {
        RezervasyonEntity entity = rezervasyonRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Rezervasyon bulunamadı!",
                        HttpStatus.NOT_FOUND.toString())));
        cakisanRezervasyonZamanKontrol(
                request.masaId(),
                request.rezervasyonZamani(),
                request.rezervasyonSuresi(),
                request.kisiSayisi(),
                request.etkinlikTip(),
                request.id());
        LocalDateTime bitisZamani = request.rezervasyonZamani().plusMinutes(request.rezervasyonSuresi());
        RezervasyonDurum durum = (request.durum() != null) ? request.durum() : entity.getDurum();
        if (bitisZamani.isAfter(LocalDateTime.now()) &&
                (durum == RezervasyonDurum.SURESI_DOLDU || durum == RezervasyonDurum.TAMAMLANDI)) {
            throw new BaseException(GenericResponse.error(
                    "Rezervasyon süresi dolmadan bu durumu set edemezsiniz!",
                    HttpStatus.BAD_REQUEST.toString()
            ));
        }
        entity.setMusteriAd(request.musteriAd());
        entity.setMasaId(request.masaId());
        entity.setEtkinlikTip(request.etkinlikTip());
        entity.setRezervasyonZamani(request.rezervasyonZamani());
        entity.setRezervasyonSuresi(request.rezervasyonSuresi());
        entity.setKisiSayisi(request.kisiSayisi());
        entity.setDurum(request.durum());

        RezervasyonEntity saved = rezervasyonRepository.save(entity);
        updateMasaDurum(saved);

        return saved.getId();
    }


    private void updateMasaDurum(RezervasyonEntity rezervasyon) {
        MasaEntity masa = masaRepository.findById(rezervasyon.getMasaId()).orElse(null);
        if (masa == null) return;

        LocalDateTime bitisZamani = rezervasyon.getRezervasyonZamani().plusMinutes(rezervasyon.getRezervasyonSuresi());

        if (rezervasyon.getDurum() == RezervasyonDurum.ONAYLANDI) {
            if (bitisZamani.isBefore(LocalDateTime.now())) {
                masa.setMasaDurum(MasaDurumu.KONTROL_BEKLIYOR);
            } else {
                masa.setMasaDurum(MasaDurumu.REZERVE);
            }
        } else {
            masa.setMasaDurum(MasaDurumu.BOS);
        }
        masaRepository.save(masa);
    }

    private void cakisanRezervasyonZamanKontrol(Long masaId, LocalDateTime baslangic, Integer sure, Integer kisiSayisi, EtkinlikTipEnum etkinlikTip, Long rezervasyonId)
    {
        if (baslangic.isBefore(LocalDateTime.now())) {
            throw new BaseException(GenericResponse.error(
                    "Geçmiş bir tarihe rezervasyon yapılamaz!",
                    HttpStatus.BAD_REQUEST.toString()
            ));
        }

        MasaEntity masa = masaRepository.findById(masaId)
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Masa bulunamadı!",
                        HttpStatus.NOT_FOUND.toString()
                )));

        if (masa.getKapasite() == null || kisiSayisi > masa.getKapasite()) {
            throw new BaseException(GenericResponse.error(
                    "Kişi sayısı masa kapasitesini aşıyor!",
                    HttpStatus.BAD_REQUEST.toString()
            ));
        }

        RezervasyonSureAyarEntity ayar = rezervasyonSureAyarRepository.fetchByEtkinlikTip(etkinlikTip);
        if (ayar == null || !ayar.getAktif()) {
            throw new BaseException(GenericResponse.error(
                    "Etkinlik tipi için süre ayarı bulunamadı veya aktif değil!",
                    HttpStatus.BAD_REQUEST.toString()
            ));
        }

        Integer atanacakSure = (sure == null) ? ayar.getVarsayilanSure() : sure;

        LocalDateTime bitis = baslangic.plusMinutes(atanacakSure);


        List<RezervasyonEntity> cakisanRezervasyonlar;
        if (rezervasyonId == null) {
            // Yeni rezervasyon
            cakisanRezervasyonlar = rezervasyonRepository.fetchCakisanRezervasyonlar(masaId, baslangic, bitis);
        } else {
            // Güncelleme,
            cakisanRezervasyonlar = rezervasyonRepository.fetchMevcutRezervasyonHaricCakisanMevcutRezervasyonlar(masaId, baslangic, bitis, rezervasyonId);
        }
        if (!cakisanRezervasyonlar.isEmpty()) {
            throw new BaseException(GenericResponse.error(
                    "Bu zaman aralığında masa zaten rezerve!",
                    HttpStatus.CONFLICT.toString()
            ));
        }
    }

     @Override
     public String deleteRezervasyon(RezervasyonDeleteRequest request) {
        RezervasyonEntity entity = rezervasyonRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Rezervasyon bulunamadı!",
                        HttpStatus.NOT_FOUND.toString()
                )));
        rezervasyonRepository.deleteById(request.id());

        MasaEntity masa = masaRepository.findById(request.masaId()).orElse(null);
        if (masa != null) {
            masa.setMasaDurum(MasaDurumu.BOS);
            masaRepository.save(masa);
        }
        return "Rezervasyon silindi.";
    }

    // ------------------ Scheduler ------------------
    @Scheduled(fixedRate = 60000)
    @Override
    public void kontrolRezervasyonScheduler() {
        List<RezervasyonEntity> aktifRezervasyonlar = rezervasyonRepository.fetchByDurum(RezervasyonDurum.ONAYLANDI);
        for (RezervasyonEntity rez : aktifRezervasyonlar) {
            LocalDateTime bitisZamani = rez.getRezervasyonZamani().plusMinutes(rez.getRezervasyonSuresi());
            if (bitisZamani.isBefore(LocalDateTime.now())) {
                rez.setDurum(RezervasyonDurum.SURESI_DOLDU);
                updateMasaDurum(rez);
                rezervasyonRepository.save(rez);
            }
        }
        log.info("Scheduler: Süresi dolmuş rezervasyonlar kontrol edildi.");
    }
}