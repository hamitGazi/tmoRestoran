package hamit.demir.service;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.repository.MasaRepository;
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
public class MasaServiceImpl implements MasaService {

    private final MasaRepository masaRepository;


    @Override
    public List<MasaResponse> getAllMasalar() {
        return masaRepository.fetchAllMasalar();
    }

    @Override
    public MasaResponse getMasaById(Long id) {

        return masaRepository.fetchMasaById(id);
    }

    @Override
    public Long saveMasa(MasaSaveRequest request) {
        MasaEntity masaEntity = new MasaEntity();
        masaEntity.setQrKodUrl(request.qrKodUrl());
        masaEntity.setKapasite(request.kapasite());
        masaEntity.setMasaKonum(request.masaKonum());
        masaEntity.setOlusturmaTarih(LocalDateTime.now());
        return masaRepository.save(masaEntity).getId();
    }

    @Override
    public Long updateMasa(MasaUpdateRequest request) {
        MasaEntity masaEntity = masaRepository.findById(request.id())
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Masa Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        masaEntity.setQrKodUrl(request.qrKodUrl());
        masaEntity.setKapasite(request.kapasite());
        masaEntity.setMasaKonum(request.masaKonum());
        masaEntity.setMasaDurum(request.masaDurum());
        return masaRepository.save(masaEntity).getId();
    }

    @Override
    public String deleteMasa(Long id) {
        MasaEntity masaEntity = masaRepository.findById(id)
                .orElseThrow(() -> new BaseException(
                        GenericResponse.error("Masa Bulunamadı! Lütfen tekrar deneyiniz..", HttpStatus.NOT_FOUND.toString())));
        masaRepository.deleteById(masaEntity.getId());
        return "Silme işlemi başarılı";
    }
}
