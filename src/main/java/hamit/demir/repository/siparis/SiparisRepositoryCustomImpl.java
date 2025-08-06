package hamit.demir.repository.siparis;

import com.querydsl.core.types.Projections;
import hamit.demir.model.dto.masa.MasaResponse;
import hamit.demir.model.dto.personel.PersonelResponse;
import hamit.demir.model.dto.siparis.SiparisResponse;
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
    public List<SiparisResponse> getAllSiparisler() {
        QSiparisEntity root = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        QPersonelEntity personel = QPersonelEntity.personelEntity;
        return from(root).leftJoin(root.masa,masa).leftJoin(root.personel,personel).select(Projections.constructor(SiparisResponse.class,
                root.id,
                Projections.constructor(MasaResponse.class,
                        masa.id,
                        masa.qrKodUrl),
                root.musteriAd,
                root.toplamTutar,
                Projections.constructor(PersonelResponse.class,
                        personel.id,
                        personel.ad,
                        personel.soyad),
                root.olusturmaZamani,
             //   root.durum,
                root.not)).fetch();
    }

    @Override
    public SiparisResponse fetchSiparisById(Long id) {
        QSiparisEntity root = QSiparisEntity.siparisEntity;
        QMasaEntity masa = QMasaEntity.masaEntity;
        QPersonelEntity personel = QPersonelEntity.personelEntity;
        return from(root).leftJoin(root.masa,masa).leftJoin(root.personel,personel).select(Projections.constructor(SiparisResponse.class,
                root.id,
                Projections.constructor(MasaResponse.class,
                        masa.id,
                        masa.qrKodUrl),
                root.musteriAd,
                root.toplamTutar,
                Projections.constructor(PersonelResponse.class,
                        personel.id,
                        personel.ad,
                        personel.soyad),
                root.olusturmaZamani,
               /* root.durum,*/
                root.not)).where(root.id.eq(id)).fetchOne();
    }
}
