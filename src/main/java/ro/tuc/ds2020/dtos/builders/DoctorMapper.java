package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.entities.UserDetails;

@Component
public class DoctorMapper implements IMapper<DoctorDTO, UserDetails>{


    protected MapperFacade mapper = null;

    public DoctorMapper(){
        if(mapper == null) {
            final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(UserDetails.class, DoctorDTO.class)
                    .byDefault()
                    .register();
            mapper = mapperFactory.getMapperFacade();
        }
    }

    @Override
    public UserDetails toEntity(DoctorDTO dto) {
        return mapper.map(dto, UserDetails.class);
    }

    @Override
    public DoctorDTO toDTO(UserDetails entity) {
        return mapper.map(entity, DoctorDTO.class);
    }
}
