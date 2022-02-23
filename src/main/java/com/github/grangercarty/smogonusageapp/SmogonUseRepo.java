package com.github.grangercarty.smogonusageapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SmogonUseRepo {
    public ArrayList<SmogonPokemonUse> usageList;

    public SmogonUseRepo() {
        usageList = new ArrayList<>();
    }

    public void load(String fileName) {
        String filePath = Objects.requireNonNull(App.class.getClassLoader().getResource(fileName)).getFile();
        File file = new File(filePath);
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                String smogonUseLine = sc.next();
                SmogonPokemonUse smoPokeUse = new SmogonPokemonUse(smogonUseLine);
                usageList.add(smoPokeUse);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file path.");
            e.printStackTrace();
        }
    }

    public void print() {
        for (SmogonPokemonUse pokeUse : usageList) {
            System.out.println(pokeUse);
        }
    }
}
