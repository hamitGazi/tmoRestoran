package hamit.demir.repository.stokHareket;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.menuFiyat.MenuFiyatAllResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class StokHareketRepositoryCustomImpl extends QuerydslRepositorySupport implements StokHareketRepositoryCustom {
    public StokHareketRepositoryCustomImpl() {
        super(StokHareketEntity.class);
    }


    @Override
    public Long fethStokKalemByHareket(Long stokKalemId) {
        QStokHareketEntity root = QStokHareketEntity.stokHareketEntity;


        return from(root).select(root.id).where(root.stokKalemi.id.eq(stokKalemId)).fetchOne();
    }


}