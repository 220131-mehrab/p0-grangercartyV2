package com.github.grangercarty.smogonusageapp;

import org.apache.catalina.LifecycleException;

/**
 * The entry point for smogonappv2. Upon running, data should be available at localhost:8080/smogonUse
 */
public class App {

    /**
     * Constructs a SmogonUseRepo, and loads data from a text file into it. Starts a service to access data in the repo,
     * then starts a server that uses the service.
     */
    public static void main(String[] args) {
        SmogonUseRepo smoUseRepo = new SmogonUseRepo();
        smoUseRepo.load("gen8ou_2022_01.txt");
        SmogonUseService service = new SmogonUseService(smoUseRepo);
        SmogonUseServer server = new SmogonUseServer(service);
        try {
            server.getTomcat().start();
        } catch (LifecycleException e) {
            System.err.println("Server failed to start");
            e.printStackTrace();
        }
    }
}
