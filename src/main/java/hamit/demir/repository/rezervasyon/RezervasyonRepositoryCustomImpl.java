package hamit.demir.repository.rezervasyon;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.Expressions;
import hamit.demir.model.dto.rezervasyon.RezervasyonResponse;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QRezervasyonEntity;
import hamit.demir.model.entity.RezervasyonDurum;
import hamit.demir.model.entity.RezervasyonEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;
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
                        root.rezervasyonSuresi,
                        root.kisiSayisi,
                        root.durum,
                        root.olusturmaTarih,
                        root.etkinlikTip
                ))
                .fetch();
    }

    @Override
    public List<RezervasyonEntity> fetchCakisanRezervasyonlar(Long masaId, LocalDateTime yeniBaslangic, LocalDateTime yeniBitis) {
        QRezervasyonEntity root = QRezervasyonEntity.rezervasyonEntity;


        List<RezervasyonEntity> rezervayonlar = from(root)
                .select(root)
                .where(root.masaId.eq(masaId)
                        .and(root.rezervasyonZamani.before(yeniBitis))
                ).fetch();

        return rezervayonlar.stream()
                .filter(r -> r.getRezervasyonZamani().plusMinutes(r.getRezervasyonSuresi()).isAfter(yeniBaslangic))
                .toList();
    }

    @Override
    public List<RezervasyonEntity> fetchByDurum(RezervasyonDurum rezervasyonDurum) {
        QRezervasyonEntity root = QRezervasyonEntity.rezervasyonEntity;
        return from(root)
                .where(root.durum.eq(rezervasyonDurum))
                .fetch();
    }
    @Override
    public List<RezervasyonEntity> fetchMevcutRezervasyonHaricCakisanMevcutRezervasyonlar(
            Long masaId,
            LocalDateTime yeniBaslangic,
            LocalDateTime yeniBitis,
            Long rezervasyonId
    ) {
        QRezervasyonEntity root = QRezervasyonEntity.rezervasyonEntity;

        List<RezervasyonEntity> rezervayonlar = from(root)
                .select(root)
                .where(
                        root.masaId.eq(masaId)
                                .and(root.rezervasyonZamani.before(yeniBitis))
                                .and(root.id.ne(rezervasyonId))
                ).fetch();

        return rezervayonlar.stream()
                .filter(r -> r.getRezervasyonZamani().plusMinutes(r.getRezervasyonSuresi()).isAfter(yeniBaslangic))
                .toList();
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
                        root.rezervasyonSuresi,
                        root.kisiSayisi,
                        root.durum,
                        root.olusturmaTarih,
                        root.etkinlikTip
                ))
                .where(root.id.eq(id))
                .fetchOne();
    }
}