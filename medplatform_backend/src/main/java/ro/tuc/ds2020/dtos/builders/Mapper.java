package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.BaseDTO;
import ro.tuc.ds2020.entities.BaseEntity;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Mapper<DTO extends BaseDTO, Entity extends BaseEntity> implements IMapper<DTO, Entity>{

    protected MapperFacade mapper = null;

    @Autowired
    private List<IOrikaMapper> mappers;

    @PostConstruct
    public void init(){
        if(mapper == null){
            final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mappers.forEach(mappingSupplier -> mappingSupplier.addMapping(mapperFactory));
            this.mapper = mapperFactory.getMapperFacade();
        }

    }


    @Override
    public Entity toEntity(DTO dto) {
        return (Entity) mapper.map(dto, BaseEntity.class);
    }

    @Override
    public DTO toDTO(Entity entity) {
        return (DTO) mapper.map(entity, BaseDTO.class);
    }
}
