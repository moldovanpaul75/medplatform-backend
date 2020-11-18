package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.services.CaregiverService;
import ro.tuc.ds2020.services.DoctorService;
import ro.tuc.ds2020.services.ICaregiverService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/caregiver")
public class CaregiverController extends Controller<CaregiverDTO> {

    @Autowired
    protected CaregiverController(ICaregiverService facade){
        super(facade);
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public ResponseEntity<CaregiverDTO> get2(@PathVariable(value = "id") UUID id) {
        Optional<CaregiverDTO> dto = ((CaregiverService)facade).findUserByAuthId(id);
        if(!dto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto.get(), HttpStatus.OK);
    }
}
