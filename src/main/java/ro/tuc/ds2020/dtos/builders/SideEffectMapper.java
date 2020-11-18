package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.SideEffectDTO;
import ro.tuc.ds2020.entities.SideEffect;

@Component
public class SideEffectMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(SideEffect.class, SideEffectDTO.class)
                .byDefault()
                .register();
    }
}
