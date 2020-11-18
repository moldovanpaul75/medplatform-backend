package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.controllers.Controller;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.services.DoctorService;
import ro.tuc.ds2020.services.IDoctorService;
import ro.tuc.ds2020.services.IService;
import ro.tuc.ds2020.services.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(value = "/doctor")
public class DoctorController extends Controller<DoctorDTO> {

    @Autowired
    protected DoctorController(IDoctorService facade) {
        super(facade);
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public ResponseEntity<DoctorDTO> get2(@PathVariable(value = "id") UUID id) {
        Optional<DoctorDTO> dto = ((DoctorService)facade).findUserByAuthId(id);
        if(!dto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto.get(), HttpStatus.OK);
    }
}
