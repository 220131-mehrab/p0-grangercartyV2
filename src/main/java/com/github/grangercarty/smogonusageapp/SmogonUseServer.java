package com.github.grangercarty.smogonusageapp;

import org.apache.catalina.startup.Tomcat;

public class SmogonUseServer {
    Tomcat tomcat;
    SmogonUseServlet servlet;

    /**
     * Constructs a new tomcat server.
     * @param service - A SmogonUseService that the server should be using
     */
    public SmogonUseServer(SmogonUseService service) {
        tomcat = new Tomcat();
        servlet = new SmogonUseServlet(service);
        tomcat.getConnector();
        tomcat.addContext("", null);
        tomcat.addServlet("", "smoUseServlet", servlet).addMapping("/smogonUse");
    }

    /**
     * A getter for the tomcat server.
     * @return A tomcat server
     */
    public Tomcat getTomcat() {
        return tomcat;
    }
}
