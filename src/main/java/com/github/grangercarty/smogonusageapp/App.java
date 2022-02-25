package com.github.grangercarty.smogonusageapp;

import org.apache.catalina.LifecycleException;

public class App {
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
