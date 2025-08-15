package hamit.demir.service.odeme;

import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.dto.odeme.OdemeSaveRequest;
import hamit.demir.model.dto.odeme.OdemeUpdateRequest;
import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.OdemeEntity;
import hamit.demir.repository.odeme.OdemeRepository;
import hamit.demir.repository.siparis.SiparisRepository;
import hamit.demir.service.siparis.SiparisService;
import hamit.demir.service.stokKalemi.StokKalemService;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/*
@Service
@Transactional
@RequiredArgsConstructor
public class OdemeServiceImpl implements OdemeService {

    private final OdemeRepository odemeRepository;
    private final SiparisRepository siparisRepository;
    private final SiparisService siparisService;

    @Override
    public List<OdemeResponse> getAllOdemeler() {
        return odemeRepository.fetchAllOdemeler();
    }

    @Override
    public OdemeResponse getOdemeById(Long id) {
        return odemeRepository.fetchOdemeById(id);
    }

    @Override
    public Long saveOdeme(OdemeSaveRequest request) {

            OdemeEntity entity = odemeRepository.findById(request.id())
                    .orElseThrow(() -> new BaseException(
                            GenericResponse.error("Ödeme Bulunamadı! Lütfen tekrar deneyiniz..",
                                    HttpStatus.NOT_FOUND.toString())));

            if (entity.getOdemeDurum() == OdemeDurumu.BASARILI) {
                throw new BaseException(
                        GenericResponse.error("Bu ödeme zaten başarılı olarak tamamlanmış. Tekrar ödeme yapılamaz.",
                                HttpStatus.BAD_REQUEST.toString()));
            }
            if (entity.getOdemeDurum() == OdemeDurumu.IPTAL_EDILDI) {
                throw new BaseException(
                        GenericResponse.error("Bu ödeme iptal edilmiş. Tekrar ödeme yapılamaz.",
                                HttpStatus.BAD_REQUEST.toString()));
            }
        entity.setToplamTutar(request.toplamTutar());
        entity.setYontemi(request.odemeYontem());
        entity.setOdemeDurum(request.odemeDurum());
        entity.setSiparis(siparisRepository.getReferenceById(request.siparis()));
        entity.setOdemeZamani(request.odemeZaman());
        OdemeEntity savedEntity = odemeRepository.save(entity);

        // Ödeme başarılıysa stok düş
        if (request.odemeDurum() == OdemeDurumu.BASARILI) {
            siparisService.siparisOdmeAndUpdateStok(savedEntity.getId());
        }

        return savedEntity.getId();
    }

    @Override
    public Long updateOdeme(OdemeUpdateRequest request) {
        OdemeEntity entity = odemeRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Ödeme Bulunamadı! Lütfen tekrar deneyiniz..",
                                HttpStatus.NOT_FOUND.toString())));

        // Mevcut ödeme durumu kontrolü
        if (entity.getOdemeDurum() == OdemeDurumu.BASARILI) {
            throw new BaseException(
                    GenericResponse.error("Başarılı olarak tamamlanmış ödemeler güncellenemez.",
                            HttpStatus.BAD_REQUEST.toString()));
        }

        if (entity.getOdemeDurum() == OdemeDurumu.IPTAL_EDILDI) {
            throw new BaseException(
                    GenericResponse.error("İptal edilmiş ödemeler güncellenemez.",
                            HttpStatus.BAD_REQUEST.toString()));
        }
        entity.setOdemeDurum(request.odemeDurum());
        entity.setOdemeZamani(LocalDateTime.now());

        OdemeEntity savedEntity = odemeRepository.save(entity);

        // Ödeme başarılıysa stok düş
        if (request.odemeDurum() == OdemeDurumu.BASARILI) {
            siparisService.siparisOdmeAndUpdateStok(savedEntity.getId());
        }

        return savedEntity.getId();
    }

    @Override
    public String deleteOdeme(Long id) {
        OdemeEntity entity = odemeRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Odeme Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        odemeRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }

}*/
@Service
@Transactional
@RequiredArgsConstructor
public class OdemeServiceImpl implements OdemeService {
    private final OdemeRepository odemeRepository;
    private final SiparisRepository siparisRepository;
    private final StokKalemService stokKalemService;

    @Override
    public List<OdemeResponse> getAllOdemeler() {
        return odemeRepository.fetchAllOdemeler();
    }

    @Override
    public OdemeResponse getOdemeById(Long id) {
        return odemeRepository.fetchOdemeById(id);
    }

    @Override
    public Long saveOdeme(OdemeSaveRequest request) {
        OdemeEntity entity = odemeRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Ödeme bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        if (entity.getOdemeDurum() == OdemeDurumu.BASARILI) {
            throw new BaseException(
                    GenericResponse.error("Bu ödeme zaten başarılı. Tekrar ödeme yapılamaz.",
                            HttpStatus.BAD_REQUEST.toString()));
        }
        if (entity.getOdemeDurum() == OdemeDurumu.IPTAL_EDILDI) {
            throw new BaseException(
                    GenericResponse.error("Bu ödeme iptal edilmiş. Tekrar ödeme yapılamaz.",
                            HttpStatus.BAD_REQUEST.toString()));
        }

        entity.setToplamTutar(request.toplamTutar());
        entity.setYontemi(request.odemeYontem());
        entity.setOdemeDurum(request.odemeDurum());
        entity.setSiparis(siparisRepository.getReferenceById(request.siparis()));
        entity.setOdemeZamani(request.odemeZaman());
        OdemeEntity savedEntity = odemeRepository.save(entity);

        if (request.odemeDurum() == OdemeDurumu.BASARILI) {
            stokKalemService.decreaseStockForOrder(savedEntity.getSiparis().getId());
        } else if (request.odemeDurum() == OdemeDurumu.IPTAL_EDILDI) {
            stokKalemService.restoreStockForOrder(savedEntity.getSiparis().getId());
        }

        return savedEntity.getId();
    }

    @Override
    public Long updateOdeme(OdemeUpdateRequest request) {
        OdemeEntity entity = odemeRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Ödeme bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        if (entity.getOdemeDurum() == OdemeDurumu.BASARILI) {
            throw new BaseException(
                    GenericResponse.error("Başarılı ödemeler güncellenemez.",
                            HttpStatus.BAD_REQUEST.toString()));
        }
        if (entity.getOdemeDurum() == OdemeDurumu.IPTAL_EDILDI) {
            throw new BaseException(
                    GenericResponse.error("İptal edilmiş ödemeler güncellenemez.",
                            HttpStatus.BAD_REQUEST.toString()));
        }

        entity.setOdemeDurum(request.odemeDurum());
        entity.setOdemeZamani(LocalDateTime.now());
        OdemeEntity savedEntity = odemeRepository.save(entity);

        if (request.odemeDurum() == OdemeDurumu.BASARILI) {
            stokKalemService.decreaseStockForOrder(savedEntity.getSiparis().getId());
        } else if (request.odemeDurum() == OdemeDurumu.IPTAL_EDILDI) {
            stokKalemService.restoreStockForOrder(savedEntity.getSiparis().getId());
        }

        return savedEntity.getId();
    }

    @Override
    public String deleteOdeme(Long id) {
        OdemeEntity entity = odemeRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Ödeme bulunamadı!", HttpStatus.NOT_FOUND.toString())));
        if (entity.getOdemeDurum() == OdemeDurumu.BASARILI) {
            entity.setOdemeDurum(OdemeDurumu.IPTAL_EDILDI);
            odemeRepository.save(entity);
            stokKalemService.restoreStockForOrder(entity.getSiparis().getId());
        }
        odemeRepository.deleteById(entity.getId());
        return "Silme işlemi başarılı";
    }
}