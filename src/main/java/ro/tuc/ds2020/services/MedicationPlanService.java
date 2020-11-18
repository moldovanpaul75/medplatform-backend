package ro.tuc.ds2020.services;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.repositories.MedicationPlanRepository;

@Component
public class MedicationPlanService extends Service<MedicationPlanDTO, MedicationPlan> implements IMedicationPlanService {

    protected MedicationPlanService(MedicationPlanRepository repository, IMapper<MedicationPlanDTO, MedicationPlan> mapper) {
        super(repository, mapper);
    }
}
