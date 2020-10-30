package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.entities.UserDetails;

@Component
public class DoctorMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserDetails.class, DoctorDTO.class)
                .byDefault()
                .register();
    }
}
