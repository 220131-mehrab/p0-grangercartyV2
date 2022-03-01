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
                if (SmogonPokemonUse.isPokemonUse(smogonUseLine)){
                    SmogonPokemonUse smoPokeUse = new SmogonPokemonUse(smogonUseLine);
                    addUse(smoPokeUse);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find file path.");
            e.printStackTrace();
        }
    }

    public ArrayList<SmogonPokemonUse> getUsageList() {
        return usageList;
    }

    public void addUse(SmogonPokemonUse pokeUse) {
        usageList.add(pokeUse);
    }

    public String getUsageListAsHTMLTable() {
        StringBuilder HTMLTable = new StringBuilder();
        HTMLTable.append("<table>\n");
        HTMLTable.append("<tr><th>Rank</th><th>Pokemon Name</th><th>Usage%</th></tr>\n");
        for (SmogonPokemonUse pokeUse : usageList) {
            HTMLTable.append(pokeUse.toHTMLTableRow());
        }
        HTMLTable.append("</table>\n");
        return HTMLTable.toString();
    }
}
