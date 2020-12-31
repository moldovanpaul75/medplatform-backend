package ro.tuc.ds2020.rmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import ro.tuc.ds2020.services.MedicationPlanService;

@Configuration
public class ConfigRMI {

    @Autowired
    private MedicationPlanService medicationPlanService;

    @Bean
    RemoteExporter registerRMIExporter(){
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("medplanrmi");
        exporter.setServiceInterface(IMedPlanRMI.class);
        exporter.setService(new MedPlanRMI(medicationPlanService));
        //exporter.setRegistryPort(1099);

        return exporter;
    }
}
