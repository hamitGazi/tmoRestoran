package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterRequest;
import hamit.demir.model.dto.raporlar.geriBildirim.GeriBildirimRaporFilterResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class GeriBildirimRepositoryCustomImpl extends QuerydslRepositorySupport implements GeriBildirimRepositoryCustom {
    public GeriBildirimRepositoryCustomImpl() {
        super(MusteriGeriBildirimEntity.class);
    }

    @Override
    public List<GeriBildirimRaporFilterResponse> fetchGeriBildirimRaporlari(GeriBildirimRaporFilterRequest filter) {
        QMusteriGeriBildirimEntity root = QMusteriGeriBildirimEntity.musteriGeriBildirimEntity;

        var query = from(root)
                .select(Projections.constructor(GeriBildirimRaporFilterResponse.class,
                        root.id,
                        root.olusturmaTarih,
                        root.geriBildirimTur.as("geriBildirimTuru"),
                        root.puan,
                        root.yorum
                ));

        if (filter.gecerlilikBaslangic() != null) {
            query.where(root.olusturmaTarih.goe(filter.gecerlilikBaslangic()));
        }
        if (filter.gecerlilikBitis() != null) {
            query.where(root.olusturmaTarih.loe(filter.gecerlilikBitis()));
        }
        if (filter.geriBildirimTuru() != null) {
            query.where(root.geriBildirimTur.eq(GeriBildirimTuruEnum.valueOf(filter.geriBildirimTuru())));
        }

        return query.fetch();
    }
}