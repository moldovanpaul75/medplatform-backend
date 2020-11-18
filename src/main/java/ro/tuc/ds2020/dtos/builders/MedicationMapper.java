package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.entities.Medication;

@Component
public class MedicationMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(Medication.class, MedicationDTO.class)
                .byDefault()
                .register();
    }
}
