package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserDetails;
import ro.tuc.ds2020.repositories.IBaseRepository;
import ro.tuc.ds2020.repositories.UserDetailsRepository;

import java.util.UUID;

@Component
public class PatientService extends Service<PatientDTO, UserDetails> implements IPatientService {
    protected PatientService(UserDetailsRepository repository, IMapper<PatientDTO, UserDetails> mapper) {
        super(repository, mapper);
    }
}
