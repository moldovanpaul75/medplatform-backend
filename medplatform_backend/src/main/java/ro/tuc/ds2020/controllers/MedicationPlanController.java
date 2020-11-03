package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.services.IService;

@RestController
@RequestMapping(value = "/medication_plan")
public class MedicationPlanController extends Controller<MedicationPlanDTO>{

    @Autowired
    protected MedicationPlanController(IService<MedicationPlanDTO> facade) {
        super(facade);
    }
}
