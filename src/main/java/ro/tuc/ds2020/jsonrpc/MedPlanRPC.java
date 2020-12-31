package ro.tuc.ds2020.jsonrpc;

import com.google.gson.Gson;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
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


    public String findMedicationPlanById(UUID patientID) {
        Gson gson = new Gson();
        List<MedicationPlanDTO> medPlans = medicationPlanService.findAllByPatientId(patientID);
        System.out.println(gson.toJson(medPlans));
        return gson.toJson(medPlans);
    }


    public String receiveMessage(String msg) {
        System.out.println(msg);
        return msg + " :: Response time - > " + new Date();
    }
}
