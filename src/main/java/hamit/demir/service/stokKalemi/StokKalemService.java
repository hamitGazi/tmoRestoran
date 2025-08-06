package hamit.demir.service.stokKalemi;

import hamit.demir.model.dto.StokKalemi.StokKalemiResponse;
import hamit.demir.model.dto.StokKalemi.StokKalemiSaveRequest;
import hamit.demir.model.dto.StokKalemi.StokKalemiUpdateRequest;

import java.util.List;

public interface StokKalemService {

    List<StokKalemiResponse> getAllStokKalemler();

    StokKalemiResponse getStokKalemById(Long id);

    Long saveStokKalem(StokKalemiSaveRequest request);

    Long updateStokKalem(StokKalemiUpdateRequest request);



}
