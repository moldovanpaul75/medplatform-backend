package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.controllers.Controller;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.services.DoctorService;
import ro.tuc.ds2020.services.IDoctorService;
import ro.tuc.ds2020.services.IService;

import java.util.List;


@RestController
@RequestMapping(value = "/doctor")
public class DoctorController extends Controller<DoctorDTO> {

    @Autowired
    protected DoctorController(IDoctorService facade) {
        super(facade);
    }

}
