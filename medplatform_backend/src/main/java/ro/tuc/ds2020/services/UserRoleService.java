package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.UserRoleDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserRole;
import ro.tuc.ds2020.repositories.UserRoleRepository;

import java.util.Optional;

@Component
public class UserRoleService extends Service<UserRoleDTO, UserRole> implements IUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IUserRoleService.class);

    protected UserRoleService(UserRoleRepository repository, IMapper<UserRoleDTO, UserRole> mapper) {
        super(repository, mapper);
    }

    @Override
    public Optional<UserRoleDTO> findByName(String name) {

        Optional<UserRole> userRole = ((UserRoleRepository) repository).findByName(name);
        if(!userRole.isPresent()){
            LOGGER.error("{} could not find role {} in db", this.getClass().getSimpleName(), name);
        }

        return userRole.map(mapper::toDTO);
    }
}
