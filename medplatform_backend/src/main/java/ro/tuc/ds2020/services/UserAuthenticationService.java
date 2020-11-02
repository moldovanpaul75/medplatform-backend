package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserAuthentication;
import ro.tuc.ds2020.repositories.UserAuthenticationRepository;


@Component
public class UserAuthenticationService extends Service<UserAuthenticationDTO, UserAuthentication> implements IUserAuthenticationService, UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IUserAuthenticationService.class);


    protected UserAuthenticationService(UserAuthenticationRepository repository, IMapper<UserAuthenticationDTO, UserAuthentication> mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAuthentication user = ((UserAuthenticationRepository) repository).findByUsername(username)
            .orElseThrow( () -> new UsernameNotFoundException("User Not Found with username: " + username));

        LOGGER.debug("Authenticating user {}", username);
        return mapper.toDTO(user);
    }
}
