package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
import ro.tuc.ds2020.entities.UserAuthentication;

@Component
public class UserAuthenticationMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserAuthentication.class, UserAuthenticationDTO.class)
                .byDefault()
                .register();
    }
}
