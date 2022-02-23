package com.github.grangercarty.smogonusageapp;

public class App {
    public static void main(String[] args) {
        SmogonUseRepo smoUseRepo = new SmogonUseRepo();
        smoUseRepo.load("gen8ou_2022_01.txt");
        SmogonUseService service = new SmogonUseService(smoUseRepo);
        service.printAll();
        service.printTop(5);
    }
}
