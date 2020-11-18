package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.UserDetails;

@Component
public class PatientMapper implements IMapper<PatientDTO, UserDetails>{


    protected MapperFacade mapper = null;

    public PatientMapper(){
        if(mapper == null) {
            final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(UserDetails.class, PatientDTO.class)
                    .byDefault()
                    .register();
            mapper = mapperFactory.getMapperFacade();
        }
    }

    @Override
    public UserDetails toEntity(PatientDTO dto) {
        return mapper.map(dto, UserDetails.class);
    }

    @Override
    public PatientDTO toDTO(UserDetails entity) {
        return mapper.map(entity, PatientDTO.class);
    }
}
