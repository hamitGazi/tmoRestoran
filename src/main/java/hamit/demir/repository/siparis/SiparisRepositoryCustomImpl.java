package hamit.demir.repository.siparis;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import hamit.demir.model.dto.masa.MasaIdKodResponse;
import hamit.demir.model.dto.menuItem.ProjeIdAdRecord;
import hamit.demir.model.dto.personel.PersonelIdAdResponse;
import hamit.demir.model.dto.siparis.SiparisAllResponse;
import hamit.demir.model.dto.siparisKalemi.SiparisKalemiResponse;
import hamit.demir.model.entity.QMasaEntity;
import hamit.demir.model.entity.QPersonelEntity;
import hamit.demir.model.entity.QSiparisEntity;
import hamit.demir.model.entity.SiparisEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class SiparisRepositoryCustomImpl extends QuerydslRepositorySupport implements SiparisRepositoryCustom {
    public SiparisRepositoryCustomImpl() {
        super(SiparisEntity.class);
    }


    @Override
    public List<SiparisAllResponse> getAllSiparisler() {
        QSiparisEntity root = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        QPersonelEntity personel = QPersonelEntity.personelEntity;
        return from(root).leftJoin(root.masa, masa).leftJoin(root.personel, personel).select(Projections.constructor(SiparisAllResponse.class,
                root.id,
                Projections.constructor(MasaIdKodResponse.class,
                        masa.id,
                        masa.qrKodUrl),
                root.musteriAd,
                root.toplamTutar,
                Projections.constructor(ProjeIdAdRecord.class,
                        personel.id,
                        Expressions.stringTemplate("concat({0}, ' ', {1})", personel.ad, personel.soyad)),
                root.olusturmaZamani,
                root.siparisDurumu,
                root.siparisNot)).fetch();
    }

    @Override
    public SiparisAllResponse fetchSiparisById(Long id) {
        QSiparisEntity root = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        QPersonelEntity personel = QPersonelEntity.personelEntity;
        return from(root).leftJoin(root.masa, masa).leftJoin(root.personel, personel).select(Projections.constructor(SiparisAllResponse.class,
                root.id,
                Projections.constructor(MasaIdKodResponse.class,
                        masa.id,
                        masa.qrKodUrl),
                root.musteriAd,
                root.toplamTutar,
                Projections.constructor(ProjeIdAdRecord.class,
                        personel.id,
                        Expressions.stringTemplate("concat({0}, ' ', {1})", personel.ad, personel.soyad)),
                root.olusturmaZamani,
                root.siparisDurumu,
                root.siparisNot)).where(root.id.eq(id)).fetchOne();
    }



}