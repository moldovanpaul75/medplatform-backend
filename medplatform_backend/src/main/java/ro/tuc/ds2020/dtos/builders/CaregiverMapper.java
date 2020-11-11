package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.entities.UserDetails;

@Component
public class CaregiverMapper implements IMapper<CaregiverDTO, UserDetails>{


    protected MapperFacade mapper = null;

    public CaregiverMapper(){
        if(mapper == null) {
            final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(UserDetails.class, CaregiverDTO.class)
                    .byDefault()
                    .register();
            mapper = mapperFactory.getMapperFacade();
        }
    }

    @Override
    public UserDetails toEntity(CaregiverDTO dto) {
        return mapper.map(dto, UserDetails.class);
    }

    @Override
    public CaregiverDTO toDTO(UserDetails entity) {
        return mapper.map(entity, CaregiverDTO.class);
    }
}
