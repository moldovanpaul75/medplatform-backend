package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.UserDetails;

@Component
public class PatientMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserDetails.class, PatientDTO.class)
                .byDefault()
                .register();
    }
}
