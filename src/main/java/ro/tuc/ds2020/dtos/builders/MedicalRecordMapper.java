package ro.tuc.ds2020.dtos.builders;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicalRecordDTO;
import ro.tuc.ds2020.entities.MedicalRecord;

@Component
public class MedicalRecordMapper implements IOrikaMapper{
    @Override
    public void addMapping(MapperFactory mapperFactory) {
        mapperFactory.classMap(MedicalRecord.class, MedicalRecordDTO.class)
                .byDefault()
                .register();
    }
}
