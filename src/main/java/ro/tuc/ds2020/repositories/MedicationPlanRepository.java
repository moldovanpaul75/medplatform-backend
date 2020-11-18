package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.MedicationPlan;

import java.util.UUID;

@Repository
public interface MedicationPlanRepository extends IBaseRepository<MedicationPlan, UUID>{
}
