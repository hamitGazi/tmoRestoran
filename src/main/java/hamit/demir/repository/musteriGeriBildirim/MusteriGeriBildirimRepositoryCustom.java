package hamit.demir.repository.musteriGeriBildirim;

import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;

import java.util.List;

public interface MusteriGeriBildirimRepositoryCustom {

    List<MusteriGeriBildirimResponse> fetchAllMusteriGeriBildirims();

    MusteriGeriBildirimResponse fetchMusteriGeriBildirimById(Long id);
}
