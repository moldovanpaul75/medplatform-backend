package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.MedicalRecord;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicalRecordRepository extends IBaseRepository<MedicalRecord, UUID> {

    @Query("SELECT r FROM MedicalRecord r WHERE r.patient.userAuthentication.id =:id")
    List<MedicalRecord> findAllRecordsByAuthId(@Param("id") UUID id);

}
