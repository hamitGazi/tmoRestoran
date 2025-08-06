package hamit.demir.model.dto.odeme;

import hamit.demir.model.entity.OdemeDurumu;
import hamit.demir.model.entity.OdemeYontem;

import java.time.LocalDateTime;

public record OdemeResponse (
        Long id,
        Long siparis,
        Double tutar,
        OdemeYontem yontemi,
        LocalDateTime odemeZamani,
        OdemeDurumu odemeDurumu
){
}
