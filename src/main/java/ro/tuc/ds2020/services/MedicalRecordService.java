package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicalRecordDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.MedicalRecord;
import ro.tuc.ds2020.repositories.MedicalRecordRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class MedicalRecordService extends Service<MedicalRecordDTO, MedicalRecord> implements IMedicalRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IMedicalRecordService.class);

    @Autowired
    protected MedicalRecordService(MedicalRecordRepository repository, IMapper<MedicalRecordDTO, MedicalRecord> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<MedicalRecordDTO> findAllByAuthId(UUID id) {
        LOGGER.debug("{} searched for entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(((MedicalRecordRepository) repository).findAllRecordsByAuthId(id).spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
