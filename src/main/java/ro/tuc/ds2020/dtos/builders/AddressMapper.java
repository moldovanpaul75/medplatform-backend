package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.AddressDTO;
import ro.tuc.ds2020.entities.Address;

@Component
public class AddressMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(Address.class, AddressDTO.class)
                .byDefault()
                .register();
    }
}
