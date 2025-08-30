package hamit.demir.repository.rezervasyonSureAyar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.RezevayonSureAyar.RezervasyonSureAyarResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RezervasyonSureAyarRepositoryCustomImpl extends QuerydslRepositorySupport implements RezervasyonSureAyarRepositoryCustom {
    public RezervasyonSureAyarRepositoryCustomImpl() {
        super(RezervasyonSureAyarEntity.class);
    }

    @Override
    public RezervasyonSureAyarEntity fetchByEtkinlikTip(EtkinlikTipEnum etkinlikTip) {
        QRezervasyonSureAyarEntity root = QRezervasyonSureAyarEntity.rezervasyonSureAyarEntity;
        return from(root).select(Projections.constructor(RezervasyonSureAyarEntity.class,
                root.id,
                root.etkinlikTip,
                root.varsayilanSure,
                root.minSure,
                root.maxSure,
                root.ozelDurumEsnekligi,
                root.aktif
        )).where(root.etkinlikTip.eq(etkinlikTip).and(root.aktif.eq(true))).fetchOne();
    }

    @Override
    public List<RezervasyonSureAyarResponse> fetchAllRezervasyonSureAyarlar() {
        QRezervasyonSureAyarEntity root = QRezervasyonSureAyarEntity.rezervasyonSureAyarEntity;
        return from(root).select(Projections.constructor(RezervasyonSureAyarResponse.class,
                root.id,
                root.etkinlikTip,
                root.varsayilanSure,
                root.minSure,
                root.maxSure,
                root.ozelDurumEsnekligi,
                root.aktif)).where(root.aktif.eq(true)).fetch();
    }

    @Override
    public RezervasyonSureAyarResponse fetchRezervasyonSureAyarById(Long id) {
        QRezervasyonSureAyarEntity root = QRezervasyonSureAyarEntity.rezervasyonSureAyarEntity;
        return from(root).select(Projections.constructor(RezervasyonSureAyarResponse.class,
                root.id,
                root.etkinlikTip,
                root.varsayilanSure,
                root.minSure,
                root.maxSure,
                root.ozelDurumEsnekligi,
                root.aktif)).where(root.aktif.eq(true).and(root.id.eq(id))).fetchOne();


    }
}
