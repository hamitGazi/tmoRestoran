package hamit.demir.repository.raporlar;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.StokRaporFilterResponse;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class StokRaporFilterRepositoryCustomImpl extends QuerydslRepositorySupport implements StokRaporFilterRepositoryCustom {
    public StokRaporFilterRepositoryCustomImpl() {
        super(StokKalemiEntity.class);
    }

    @Override
    public List<StokRaporFilterResponse> fetchStokRaporlari(StokRaporFilterResponse filter) {
        QStokKalemiEntity root = QStokKalemiEntity.stokKalemiEntity;
        QStokHareketEntity hareket = QStokHareketEntity.stokHareketEntity;

        var query = from(root)
                .leftJoin(hareket).on(hareket.stokKalemi.id.eq(root.id))
                .select(Projections.constructor(StokRaporFilterResponse.class,
                        root.id,
                        root.ad,
                        hareket.miktar,
                        //root.birim.name(),
                        root.kritikMiktar,
                       /* new EnumRecord(hareket.islemTipi.name(), hareket.islemTipi.getLabel()),*/
                        hareket.islemTarihi.asString()
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
    }}