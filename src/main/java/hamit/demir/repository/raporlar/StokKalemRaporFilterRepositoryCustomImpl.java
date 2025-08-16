package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.raporlar.stokKalem.StokKalemRaporResponse;
import hamit.demir.model.dto.raporlar.stokKalem.StokRaporFilterRequest;
import hamit.demir.model.entity.IslemTipEnum;
import hamit.demir.model.entity.QStokHareketEntity;
import hamit.demir.model.entity.QStokKalemiEntity;
import hamit.demir.model.entity.StokKalemiEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class StokKalemRaporFilterRepositoryCustomImpl extends QuerydslRepositorySupport implements StokKalemRaporFilterRepositoryCustom {
    public StokKalemRaporFilterRepositoryCustomImpl() {
        super(StokKalemiEntity.class);
    }

    @Override
    public List<StokKalemRaporResponse> fetchStokRaporlari(StokRaporFilterRequest filter) {
        QStokKalemiEntity root = QStokKalemiEntity.stokKalemiEntity;
        QStokHareketEntity hareket = QStokHareketEntity.stokHareketEntity;

        var query = from(root)
                .leftJoin(hareket).on(hareket.stokKalemi.id.eq(root.id))
                .select(Projections.constructor(StokKalemRaporResponse.class,
                        root.id,
                        root.ad,
                        hareket.miktar,
                        root.kritikMiktar,
                        root.birim,
                        root.aciklama,
                        hareket.islemTipi.as("islemtipi"), // field name ile eşleştir//null hatası almamak için kullanılmasında fayda var
                        hareket.islemTarihi
                ));
        if (filter.gecerlilikBaslangic() != null) {
            query.where(hareket.islemTarihi.goe(filter.gecerlilikBaslangic()));
        }
        if (filter.gecerlilikBitis() != null) {
            query.where(hareket.islemTarihi.loe(filter.gecerlilikBitis()));
        }
        if (filter.islemTipi() != null) {
            query.where(hareket.islemTipi.eq(IslemTipEnum.valueOf(filter.islemTipi())));
        }

        return query.fetch();
    }
}