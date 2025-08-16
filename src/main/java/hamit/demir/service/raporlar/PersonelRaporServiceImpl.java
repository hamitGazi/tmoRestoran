package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterRequest;
import hamit.demir.model.dto.raporlar.personleRapor.PersonelRaporFilterResponse;
import hamit.demir.repository.raporlar.PersonelRaporRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonelRaporServiceImpl implements PersonelRaporService {


    private final PersonelRaporRepository personelRepository;

    @Override
    public List<PersonelRaporFilterResponse> getPersonelRaporlari(PersonelRaporFilterRequest filter) {
        return personelRepository.fetchPersonelRaporlari(filter);
    }


}