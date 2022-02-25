package com.github.grangercarty.smogonusageapp;

import org.apache.catalina.startup.Tomcat;

public class SmogonUseServer {
    Tomcat tomcat;
    SmogonUseServlet servlet;

    public SmogonUseServer(SmogonUseService service) {
        tomcat = new Tomcat();
        servlet = new SmogonUseServlet(service);
        tomcat.getConnector();
        tomcat.addContext("", null);
        tomcat.addServlet("", "smoUseServlet", servlet).addMapping("/smogonUse");
    }

    public Tomcat getTomcat() {
        return tomcat;
    }
}
