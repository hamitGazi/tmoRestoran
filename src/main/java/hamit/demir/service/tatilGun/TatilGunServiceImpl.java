package hamit.demir.service.tatilGun;

import hamit.demir.model.dto.tatilGun.TatilGunResponse;
import hamit.demir.model.dto.tatilGun.TatilGunSaveRequest;
import hamit.demir.model.dto.tatilGun.TatilGunUpdateRequest;
import hamit.demir.model.entity.*;
import hamit.demir.repository.MasaRepository;
import hamit.demir.repository.calismaZaman.CalismaZamanRepository;
import hamit.demir.repository.tatilGun.TatilGunRepository;
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
public class TatilGunServiceImpl implements TatilGunService {

    private final TatilGunRepository tatilGunRepository;
    private final CalismaZamanRepository calismaZamanRepository;

    @Override
    public List<TatilGunResponse> getAllTatilGunleri() {
        return tatilGunRepository.fetchAllTatilGunleri();
    }

    @Override
    public TatilGunResponse getTatilGunById(Long id) {
        return tatilGunRepository.fetchTatilGunById(id);
    }

    @Override
    public List<TatilGunResponse> getTatilGunByCalismaZamanId(Long calismaZamanId) {
        return tatilGunRepository.fetchTatilGunByCalismaZamanId(calismaZamanId);
    }

    @Override
    public Long saveTatilGun(TatilGunSaveRequest request) {
        CalismaGunEnum gun = CalismaGunEnum.fromLocalDate(request.tarih());
        CalismaZamanEntity calismaZaman = calismaZamanRepository.fetchGecerliCalismaZaman(gun);

        TatilGunEntity entity = new TatilGunEntity();
        entity.setTarih(request.tarih());
        entity.setTatilTip(request.tatilTip());
        entity.setCalismaZaman(calismaZaman);
        entity.setAciklama(request.aciklama());
        entity.setAktif(request.aktif() != null ? request.aktif() : true);

        return tatilGunRepository.save(entity).getId();
    }

    @Override
    public Long updateTatilGun(TatilGunUpdateRequest request) {
        TatilGunEntity entity = tatilGunRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Güncelleme için tatil kaydı bulunamadı!",
                        HttpStatus.NOT_FOUND.toString()
                )));

        CalismaGunEnum gun = CalismaGunEnum.fromLocalDate(request.tarih());
        CalismaZamanEntity calismaZaman = calismaZamanRepository.fetchGecerliCalismaZaman(gun);

        entity.setTarih(request.tarih());
        entity.setTatilTip(request.tatilTip());
        entity.setCalismaZaman(calismaZaman);
        entity.setAciklama(request.aciklama());
        entity.setAktif(request.aktif() != null ? request.aktif() : true);

        return tatilGunRepository.save(entity).getId();
    }

    @Override
    public String deleteTatilGunById(Long id) {
        TatilGunEntity entity = tatilGunRepository.findById(id)
                .orElseThrow(() -> new BaseException(GenericResponse.error(
                        "Silinecek tatil kaydı bulunamadı!",
                        HttpStatus.NOT_FOUND.toString()
                )));
        tatilGunRepository.delete(entity);
        return "Silindi";
    }

    @Override
    public String loadResmiTatiller() {
        // JSON config veya harici kaynaktan resmi tatilleri yükle
        // Örnek: {"2026-05-19": "19 Mayıs"}
        // Her tatil için TatilGunEntity oluştur ve kaydet
        return "Resmi tatiller yüklendi";
    }

    @Override
    public Boolean uygunTarih(LocalDateTime dateTime) {
       /* TatilGunEntity tatil = tatilGunRepository.fetchGecerliTatil(dateTime.toLocalDate());
        if (tatil != null && Boolean.TRUE.equals(tatil.getAktif())) {
            CalismaGunEnum gun = CalismaGunEnum.fromLocalDate(dateTime.toLocalDate());
            CalismaZamanEntity calismaZaman = calismaZamanRepository.fetchGecerliCalismaZaman(gun);
            if (calismaZaman != null && Boolean.TRUE.equals(calismaZaman.getIstisna())) {
                return true; // istisna=true, restoran açık
            }
            return false; // Tatil var, istisna yok, restoran kapalı
        }*/
        return true; // Tatil yoksa, uygun
    }


}