package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserDetails;
import ro.tuc.ds2020.repositories.UserDetailsRepository;


@Component
public class CaregiverService extends Service<CaregiverDTO, UserDetails> implements ICaregiverService{

    protected CaregiverService(UserDetailsRepository repository, IMapper<CaregiverDTO, UserDetails> mapper) {
        super(repository, mapper);
    }
}
