package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.MedicalRecordDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/medical_record")
public class MedicalRecordController extends Controller<MedicalRecordDTO>{

    @Autowired
    public MedicalRecordController(IService<MedicalRecordDTO> facade){
        super(facade);
    }

}
