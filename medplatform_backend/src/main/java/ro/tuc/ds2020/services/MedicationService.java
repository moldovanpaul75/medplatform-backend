package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.repositories.MedicationRepository;

@Component
public class MedicationService extends Service<MedicationDTO, Medication> implements IMedicationService{
    protected MedicationService(MedicationRepository repository, IMapper<MedicationDTO, Medication> mapper) {
        super(repository, mapper);
    }
}
