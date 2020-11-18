package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/medication")
public class MedicationController extends Controller<MedicationDTO>{

    @Autowired
    protected MedicationController(IService<MedicationDTO> facade) {
        super(facade);
    }
}
