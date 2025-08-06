package hamit.demir.repository.musteriGeriBildirim;

import hamit.demir.model.dto.musteriGeriBildirim.MusteriGeriBildirimResponse;
import hamit.demir.model.entity.MusteriGeriBildirimEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MusteriGeriBildirimRepositoryCustomImpl extends QuerydslRepositorySupport implements MusteriGeriBildirimRepositoryCustom {
    public MusteriGeriBildirimRepositoryCustomImpl() {
        super(MusteriGeriBildirimEntity.class);
    }


    @Override
    public List<MusteriGeriBildirimResponse> fetchAllMusteriGeriBildirims() {
        return List.of();
    }

    @Override
    public MusteriGeriBildirimResponse fetchMusteriGeriBildirimById(Long id) {
        return null;
    }
}
