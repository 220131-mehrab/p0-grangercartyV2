package com.github.grangercarty.smogonusageapp;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {
        SmogonUseRepo smoUseRepo = new SmogonUseRepo();
        smoUseRepo.load("gen8ou_2022_01.txt");
        SmogonUseService service = new SmogonUseService(smoUseRepo);
        SmogonUseServlet smoUseServlet = new SmogonUseServlet(service);
        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "smoUseServlet", smoUseServlet).addMapping("/smogonUse");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
