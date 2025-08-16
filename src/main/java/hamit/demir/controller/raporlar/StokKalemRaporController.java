package hamit.demir.controller.raporlar;

import hamit.demir.model.dto.enumlar.EnumRecord;
import hamit.demir.model.dto.raporlar.stokKalem.StokKalemRaporResponse;
import hamit.demir.model.dto.raporlar.stokKalem.StokRaporFilterRequest;
import hamit.demir.model.entity.IslemTipEnum;
import hamit.demir.service.raporlar.StokKalemRaporService;
import hamit.demir.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rapor/stok")
@RequiredArgsConstructor
public class StokKalemRaporController {

    private final StokKalemRaporService stokRaporService;

    @PostMapping("/all")
    public GenericResponse<List<StokKalemRaporResponse>> getAll(@RequestBody StokRaporFilterRequest filter) {
        List<StokKalemRaporResponse> data = stokRaporService.getStokRaporlari(filter);
        return GenericResponse.ok(data);
    }

    @GetMapping("/islemTipi-enum")
    public GenericResponse<List<EnumRecord>> getIslemTipEnum() {
        return IslemTipEnum.islemTipEnumList();
    }
}