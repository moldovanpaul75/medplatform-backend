package ro.tuc.ds2020.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.services.IPatientService;
import ro.tuc.ds2020.services.IService;
import ro.tuc.ds2020.services.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/patient")
public class PatientController extends Controller<PatientDTO> {

    @Autowired
    protected PatientController(IService<PatientDTO> facade) {
        super(facade);
    }


    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public ResponseEntity<PatientDTO> get2(@PathVariable(value = "id") UUID id) {
        Optional<PatientDTO> dto = ((PatientService)facade).findUserByAuthId(id);
        if(!dto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto.get(), HttpStatus.OK);
    }
}
