package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.entities.Activity;

@Component
public class ActivityMapper implements IOrikaMapper{


    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(Activity.class, ActivityDTO.class)
                .field("userDetails.id", "patient_id")
                .field("activityStart", "start")
                .field("activityEnd", "end")
                .field("name", "activity")
                .byDefault()
                .register();
    }
}
