package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.MedicalRecordDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.MedicalRecord;
import ro.tuc.ds2020.repositories.MedicalRecordRepository;
import ro.tuc.ds2020.services.IService;
import ro.tuc.ds2020.services.MedicalRecordService;
import ro.tuc.ds2020.services.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/medical_record")
public class MedicalRecordController extends Controller<MedicalRecordDTO>{

    @Autowired
    public MedicalRecordController(IService<MedicalRecordDTO> facade){
        super(facade);
    }


    @RequestMapping(value = "/patient={id}", method = RequestMethod.GET)
    public ResponseEntity<List<MedicalRecordDTO>> listByAuthId(@PathVariable(value = "id") UUID id) {
        List<MedicalRecordDTO> dtos = ((MedicalRecordService) facade).findAllByAuthId(id);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
