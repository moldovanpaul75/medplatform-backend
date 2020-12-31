package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.MedicalRecord;
import ro.tuc.ds2020.entities.MedicationPlan;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicationPlanRepository extends IBaseRepository<MedicationPlan, UUID>{

    @Query("SELECT p FROM MedicationPlan p WHERE p.patient.userAuthentication.id =:id")
    List<MedicationPlan> findAllPlansByAuthId(@Param("id") UUID id);


    @Query("SELECT p FROM MedicationPlan p WHERE p.patient.id =:id")
    List<MedicationPlan> findAllPlansByPatientId(@Param("id") UUID id);
}
