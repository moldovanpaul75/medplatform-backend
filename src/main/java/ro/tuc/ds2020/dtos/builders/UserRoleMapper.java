package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.UserRoleDTO;
import ro.tuc.ds2020.entities.UserRole;

@Component
public class UserRoleMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserRole.class, UserRoleDTO.class)
                .byDefault()
                .register();
    }
}
