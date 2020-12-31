package ro.tuc.ds2020.jsonrpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.services.MedicationPlanService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AutoJsonRpcServiceImpl
public class MedPlanRPC implements IMedPlanRPC{

    @Autowired
    private MedicationPlanService medicationPlanService;


    public String sayHelloRmi(String msg) {
        System.out.println("Incoming msg : " + msg);

        return "Hello " + msg + " :: Response time - > " + new Date();
    }


    public List<MedicationPlanDTO> findMedicationPlanById(UUID patientID) {
        List<MedicationPlanDTO> medPlans = medicationPlanService.findAllByPatientId(patientID);

        return medPlans;
    }


    public String receiveMessage(String msg) {
        System.out.println(msg);
        return msg + " :: Response time - > " + new Date();
    }
}
