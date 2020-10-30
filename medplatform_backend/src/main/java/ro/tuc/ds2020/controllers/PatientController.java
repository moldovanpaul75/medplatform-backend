package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/patient")
public class PatientController extends Controller<PatientDTO> {

    @Autowired
    protected PatientController(IService<PatientDTO> facade) {
        super(facade);
    }
}
