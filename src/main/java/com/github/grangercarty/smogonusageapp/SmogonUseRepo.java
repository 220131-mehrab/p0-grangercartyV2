package com.github.grangercarty.smogonusageapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SmogonUseRepo {
    public ArrayList<SmogonPokemonUse> usageList;

    /**
     * Creates an empty SmogonUseRepo.
     */
    public SmogonUseRepo() {
        usageList = new ArrayList<>();
    }

    /**
     * Loads a file into the SmogonUseRepo
     * @param fileName - The name of the file
     */
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

    /**
     * A getter for the usageList
     * @return The usageList of SmogonPokemonUse
     */
    public ArrayList<SmogonPokemonUse> getUsageList() {
        return usageList;
    }

    /**
     * Adds a SmogonPokemonUse to the usageList.
     * @param pokeUse - A string containing usage data for a Pokemon in a metagame
     */
    public void addUse(SmogonPokemonUse pokeUse) {
        usageList.add(pokeUse);
    }

    /**
     * Gets the usageList as an HTML Table
     * @return A string that represents an HTML table
     */
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
