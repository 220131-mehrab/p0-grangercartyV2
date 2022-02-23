package com.github.grangercarty.smogonusageapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SmogonUseRepo smoUseRepo = new SmogonUseRepo();
        smoUseRepo.load("gen8ou_2022_01.txt");
        smoUseRepo.print();
    }
}
