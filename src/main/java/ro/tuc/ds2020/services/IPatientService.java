package ro.tuc.ds2020.services;

import ro.tuc.ds2020.dtos.PatientDTO;

import java.util.Optional;
import java.util.UUID;

public interface IPatientService extends IService<PatientDTO> {

    public abstract Optional<PatientDTO> findUserByAuthId(UUID id);
}
