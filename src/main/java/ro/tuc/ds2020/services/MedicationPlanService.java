package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.repositories.MedicationPlanRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MedicationPlanService extends Service<MedicationPlanDTO, MedicationPlan> implements IMedicationPlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IMedicationPlanService.class);

    @Autowired
    protected MedicationPlanService(MedicationPlanRepository repository, IMapper<MedicationPlanDTO, MedicationPlan> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<MedicationPlanDTO> findAllByAuthId(UUID id) {
        LOGGER.debug("{} searched for entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(((MedicationPlanRepository) repository).findAllPlansByAuthId(id).spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicationPlanDTO> findAllByPatientId(UUID id) {
        LOGGER.debug("{} searched for entities in table", this.getClass().getSimpleName());
        return StreamSupport.stream(((MedicationPlanRepository) repository).findAllPlansByPatientId(id).spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
