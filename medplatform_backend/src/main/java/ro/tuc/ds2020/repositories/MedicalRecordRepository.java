package ro.tuc.ds2020.repositories;

import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.MedicalRecord;

import java.util.UUID;

@Repository
public interface MedicalRecordRepository extends IBaseRepository<MedicalRecord, UUID> {
}
