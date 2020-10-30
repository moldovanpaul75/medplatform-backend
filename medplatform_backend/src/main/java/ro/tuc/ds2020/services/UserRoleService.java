package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.UserRoleDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.UserRole;
import ro.tuc.ds2020.repositories.UserRoleRepository;

@Component
public class UserRoleService extends Service<UserRoleDTO, UserRole> implements IUserRoleService {
    protected UserRoleService(UserRoleRepository repository, IMapper<UserRoleDTO, UserRole> mapper) {
        super(repository, mapper);
    }
}
