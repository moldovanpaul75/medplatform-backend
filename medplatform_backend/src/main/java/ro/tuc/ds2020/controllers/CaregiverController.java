package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.services.ICaregiverService;

@RestController
@RequestMapping(value = "/caregiver")
public class CaregiverController extends Controller<CaregiverDTO> {

    @Autowired
    protected CaregiverController(ICaregiverService facade){
        super(facade);
    }

}
