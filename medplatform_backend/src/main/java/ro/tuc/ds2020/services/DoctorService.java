package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserDetails;
import ro.tuc.ds2020.repositories.IBaseRepository;
import ro.tuc.ds2020.repositories.UserDetailsRepository;

import java.util.UUID;

@Component
public class DoctorService extends Service<DoctorDTO, UserDetails> implements IDoctorService {
    protected DoctorService(UserDetailsRepository repository, IMapper<DoctorDTO, UserDetails> mapper) {
        super(repository, mapper);
    }
}
