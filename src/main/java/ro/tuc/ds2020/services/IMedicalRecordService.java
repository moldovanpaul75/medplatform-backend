package ro.tuc.ds2020.services;

import ro.tuc.ds2020.dtos.MedicalRecordDTO;

import java.util.List;
import java.util.UUID;

public interface IMedicalRecordService extends IService<MedicalRecordDTO> {

    public abstract List<MedicalRecordDTO> findAllByAuthId(UUID id);


}
