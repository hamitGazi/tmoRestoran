package hamit.demir.service.raporlar;

import hamit.demir.model.dto.raporlar.PersonelRaporFilterResponse;
import hamit.demir.repository.personel.PersonelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonelRaporServiceImpl implements PersonelRaporService {


    private final PersonelRepository personelRepository;

    @Override
    public List<PersonelRaporFilterResponse> getPersonelRaporlari(PersonelRaporFilterResponse filter) {
        return personelRepository.fetchPersonelRaporlari(filter);
    }


}