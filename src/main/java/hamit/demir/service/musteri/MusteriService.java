package hamit.demir.service.musteri;

import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.masa.MasaSaveRequest;
import hamit.demir.model.dto.masa.MasaUpdateRequest;
import hamit.demir.model.dto.musteri.MusteriResponse;
import hamit.demir.model.dto.musteri.MusteriSaveRequest;
import hamit.demir.model.dto.musteri.MusteriUpdateRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface MusteriService {

    List<MusteriResponse> getAllMusterler();

    MusteriResponse getMusteriById(Long id);

    Long saveMusteri(MusteriSaveRequest request);


    Long updateMusteri(MusteriUpdateRequest request);

    String deleteMusteri(Long id);
}
