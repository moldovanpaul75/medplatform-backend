package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserAuthentication;
import ro.tuc.ds2020.repositories.UserAuthenticationRepository;



@Component
public class UserAuthenticationService extends Service<UserAuthenticationDTO, UserAuthentication> implements IUserAuthenticationService {
    protected UserAuthenticationService(UserAuthenticationRepository repository, IMapper<UserAuthenticationDTO, UserAuthentication> mapper) {
        super(repository, mapper);
    }
}
