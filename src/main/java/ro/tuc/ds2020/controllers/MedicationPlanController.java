package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.services.IService;
import ro.tuc.ds2020.services.MedicationPlanService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/medication_plan")
public class MedicationPlanController extends Controller<MedicationPlanDTO>{

    @Autowired
    protected MedicationPlanController(IService<MedicationPlanDTO> facade) {
        super(facade);
    }


    @RequestMapping(value = "/patient={id}", method = RequestMethod.GET)
    public ResponseEntity<List<MedicationPlanDTO>> listByAuthId(@PathVariable(value = "id") UUID id) {
        List<MedicationPlanDTO> dtos = ((MedicationPlanService) facade).findAllByAuthId(id);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
