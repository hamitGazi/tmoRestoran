package hamit.demir.repository.odeme;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.odeme.OdemeResponse;
import hamit.demir.model.entity.MasaEntity;
import hamit.demir.model.entity.OdemeEntity;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QOdemeEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class OdemeRepositoryCustomImpl extends QuerydslRepositorySupport implements OdemeRepositoryCustom {
    public OdemeRepositoryCustomImpl() {
        super(OdemeEntity.class);
    }


    @Override
    public List<OdemeResponse> fetchAllOdemeler() {
        QOdemeEntity root = QOdemeEntity.odemeEntity;
        return from(root).select(Projections.constructor(OdemeResponse.class,
                root.id,
              //  root.siparisEntity,
                root.tutar,
                root.yontemi,
                root.odemeZamani
                //root.odemeDurum
                )).fetch();
    }

    @Override
    public OdemeResponse fetchOdemeById(Long id) {
        QOdemeEntity root = QOdemeEntity.odemeEntity;
        return from(root).select(Projections.constructor(OdemeResponse.class,
                root.id,
                //root.siparisEntity,
                root.tutar,
                root.yontemi,
                root.odemeZamani
                //root.odemeDurum
        )).where(root.id.eq(id)).fetchOne();
    }

}
