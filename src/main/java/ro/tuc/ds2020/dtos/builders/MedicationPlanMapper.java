package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.entities.MedicationPlan;

@Component
public class MedicationPlanMapper implements IOrikaMapper{

    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(MedicationPlan.class, MedicationPlanDTO.class)
                .byDefault()
                .register();
    }
}
