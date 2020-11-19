package ro.tuc.ds2020.services;

import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.PatientDTO;

import java.util.Optional;
import java.util.UUID;

public interface ICaregiverService extends IService<CaregiverDTO> {

    public abstract Optional<CaregiverDTO> findUserByAuthId(UUID id);
}
