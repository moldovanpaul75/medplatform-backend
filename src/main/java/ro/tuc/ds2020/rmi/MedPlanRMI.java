package ro.tuc.ds2020.rmi;

import java.util.Date;

public class MedPlanRMI implements IMedPlanRMI{

    @Override
    public String sayHelloRmi(String msg) {
        System.out.println("================Server Side ========================");
        System.out.println("Inside Rmi IMPL - Incoming msg : " + msg);
        return "Hello " + msg + " :: Response time - > " + new Date();
    }
}
