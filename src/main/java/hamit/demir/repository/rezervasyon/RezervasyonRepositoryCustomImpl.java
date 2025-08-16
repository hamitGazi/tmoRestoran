package hamit.demir.repository.rezervasyon;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QRezervasyonEntity;
import hamit.demir.model.entity.RezervasyonEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;


public class RezervasyonRepositoryCustomImpl extends QuerydslRepositorySupport implements RezervasyonRepositoryCustom {

    public RezervasyonRepositoryCustomImpl() {
        super(RezervasyonEntity.class);
    }

    @Override
    public List<RezervasyonResponse> fetchAllRezervasyonlar() {
        QRezervasyonEntity root = QRezervasyonEntity.rezervasyonEntity;

        QMasaEntity masa = QMasaEntity.masaEntity;
        return from(root)
                .join(masa).on(root.masaId.eq(masa.id))
                .select(Projections.constructor(RezervasyonResponse.class,
                        root.id,
                        root.musteriAd,
                        root.masaId,
                        masa.qrKodUrl,
                        root.rezervasyonZamani,
                        root.kisiSayisi,
                        root.durum,
                        root.olusturmaTarih
                ))
                .fetch();
    }

    @Override
    public RezervasyonResponse fetchRezervasyonById(Long id) {
        QRezervasyonEntity root = QRezervasyonEntity.rezervasyonEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        return from(root)
                .join(masa).on(root.masaId.eq(masa.id))
                .select(Projections.constructor(RezervasyonResponse.class,
                        root.id,
                        root.musteriAd,
                        root.masaId,
                        masa.qrKodUrl,
                        root.rezervasyonZamani,
                        root.kisiSayisi,
                        root.durum,
                        root.olusturmaTarih
                ))
                .where(root.id.eq(id))
                .fetchOne();
    }
}