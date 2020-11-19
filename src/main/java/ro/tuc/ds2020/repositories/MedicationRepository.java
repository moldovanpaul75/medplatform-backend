package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Medication;

import java.util.UUID;

@Repository
public interface MedicationRepository extends IBaseRepository<Medication, UUID>{
}
