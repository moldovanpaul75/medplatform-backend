package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicalRecordDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.MedicalRecord;
import ro.tuc.ds2020.repositories.MedicalRecordRepository;


@Component
public class MedicalRecordService extends Service<MedicalRecordDTO, MedicalRecord> implements IMedicalRecordService {

    protected MedicalRecordService(MedicalRecordRepository repository, IMapper<MedicalRecordDTO, MedicalRecord> mapper) {
        super(repository, mapper);
    }
}
