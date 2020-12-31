package ro.tuc.ds2020.services;

import ro.tuc.ds2020.dtos.MedicationPlanDTO;

import java.util.List;
import java.util.UUID;

public interface IMedicationPlanService extends IService<MedicationPlanDTO> {

    public abstract List<MedicationPlanDTO> findAllByAuthId(UUID id);

    public abstract List<MedicationPlanDTO> findAllByPatientId(UUID id);
}
