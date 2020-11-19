package ro.tuc.ds2020.services;

import ro.tuc.ds2020.dtos.DoctorDTO;

import java.util.Optional;
import java.util.UUID;

public interface IDoctorService extends IService<DoctorDTO> {

    public abstract Optional<DoctorDTO> findUserByAuthId(UUID id);
}
