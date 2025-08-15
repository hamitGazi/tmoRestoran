package hamit.demir.service.stokHareket;

import hamit.demir.model.entity.IslemTipEnum;
import hamit.demir.model.entity.StokHareketEntity;
import hamit.demir.model.entity.StokKalemiEntity;
import hamit.demir.repository.stokHareket.StokHareketRepository;
import hamit.demir.repository.stokKalem.StokKalemRepository;
import hamit.demir.utils.BaseException;
import hamit.demir.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/*
@Service
@RequiredArgsConstructor
public class StokHareketServiceImpl implements StokHareketService {
    private final StokHareketRepository stokHareketRepository;
    private final StokKalemRepository stokKalemRepository;

   @Override
   public void saveHareket(Long stokKalemiId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama) {
        StokKalemiEntity stokKalemi = stokKalemRepository.findById(stokKalemiId)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Stok kalemi bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        StokHareketEntity hareket = new StokHareketEntity();
        hareket.setStokKalemi(stokKalemi);
        hareket.setIslemTipi(islemTipi);
        hareket.setMiktar(miktar);
        hareket.setOncekiMiktar(stokKalemi.getMiktar());
        hareket.setSonrakiMiktar(stokKalemi.getMiktar().add(miktar));
        hareket.setIslemTarihi(LocalDateTime.now());
        hareket.setAciklama(aciklama != null ? aciklama : islemTipi.getLabel() + " işlemi");

        stokHareketRepository.save(hareket);
    }
    @Override
    public void updateHareket(Long hareketId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama) {
        StokHareketEntity hareket = stokHareketRepository.findById(hareketId)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Hareket bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        // Stok kaleminin mevcut miktarını güncelle
        StokKalemiEntity stokKalemi = hareket.getStokKalemi();
        BigDecimal eskiHareketMiktar = hareket.getMiktar();
        BigDecimal stokFark = miktar.subtract(eskiHareketMiktar);
        stokKalemi.setMiktar(stokKalemi.getMiktar().add(stokFark));

        // Hareketi güncelle
        hareket.setMiktar(miktar);
        hareket.setIslemTipi(islemTipi);
        hareket.setOncekiMiktar(stokKalemi.getMiktar().subtract(miktar));
        hareket.setSonrakiMiktar(stokKalemi.getMiktar());
        hareket.setAciklama(aciklama != null ? aciklama : islemTipi.getLabel() + " işlemi (güncellendi)");
        hareket.setIslemTarihi(LocalDateTime.now());

        stokKalemRepository.save(stokKalemi);
        stokHareketRepository.save(hareket);
    }
}
*/


@Service
@Transactional
@RequiredArgsConstructor
public class StokHareketServiceImpl implements StokHareketService {
    private final StokHareketRepository stokHareketRepository;
    private final StokKalemRepository stokKalemRepository;

    @Override
    public void saveHareket(Long stokKalemiId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama) {

    }

    @Override
    public void updateHareket(Long hareketId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama) {

    }

    @Override
    public void createHareket(Long stokKalemiId, BigDecimal miktar, IslemTipEnum islemTipi, String aciklama) {
        StokKalemiEntity stokKalemi = stokKalemRepository.findById(stokKalemiId)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Stok kalemi bulunamadı!", HttpStatus.NOT_FOUND.toString())));

        StokHareketEntity hareket = new StokHareketEntity();
        hareket.setStokKalemi(stokKalemi);
        hareket.setIslemTipi(islemTipi);
        hareket.setMiktar(miktar);
        hareket.setOncekiMiktar(stokKalemi.getMiktar());
        hareket.setSonrakiMiktar(stokKalemi.getMiktar().add(miktar));
        hareket.setIslemTarihi(LocalDateTime.now());
        hareket.setAciklama(aciklama != null ? aciklama : islemTipi.getLabel() + " işlemi");

        stokHareketRepository.save(hareket);
    }
}