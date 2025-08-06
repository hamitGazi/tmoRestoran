package hamit.demir.service.musteriGeriBildirim;

import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimSaveRequest;
import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimUpdateRequest;

import java.util.List;

public interface MusteriGeriBildirimService {

    List<MusteriGeriBildirimResponse> getAllMusteriGeriBildirimler();

    MusteriGeriBildirimResponse getMusteriGeriBildirimById(Long id);

    Long saveMusteriGeriBildirim(MusteriGeriBildirimSaveRequest request);

    Long updateMusteriGeriBildirim(MusteriGeriBildirimUpdateRequest request);

    String deleteMusteriGeriBildirim(Long id);
}
