package hamit.demir.repository.musteri;

import hamit.demir.model.dto.musteri.MusteriResponse;

import java.util.List;

public interface MusteriRepositoryCustom {

    List<MusteriResponse> fetchAllMusterler();

    MusteriResponse fetchMusteriById(Long id);
}
