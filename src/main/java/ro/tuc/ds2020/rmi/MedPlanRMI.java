package ro.tuc.ds2020.rmi;

import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.services.MedicationPlanService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MedPlanRMI implements IMedPlanRMI{

    protected final MedicationPlanService medicationPlanService;

    public MedPlanRMI(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    @Override
    public String sayHelloRmi(String msg) {
        System.out.println("================Server Side ========================");
        System.out.println("Inside Rmi IMPL - Incoming msg : " + msg);

        return "Hello " + msg + " :: Response time - > " + new Date();
    }

    @Override
    public String receiveMessage(String msg){
        System.out.println(msg);
        return msg + " :: Response time - > " + new Date();
    }

    @Override
    public List<MedicationPlanDTO> findMedicationPlanById(UUID patientID) {
        List<MedicationPlanDTO> medPlans = medicationPlanService.findAllByPatientId(patientID);

        return medPlans;
    }
}
