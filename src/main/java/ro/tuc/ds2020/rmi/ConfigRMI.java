package ro.tuc.ds2020.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
public class ConfigRMI {

    @Bean
    RemoteExporter registerRMIExporter(){
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("medplanrmi");
        exporter.setServiceInterface(IMedPlanRMI.class);
        exporter.setService(new MedPlanRMI());
        exporter.setRegistryPort(1099);

        return exporter;
    }
}
