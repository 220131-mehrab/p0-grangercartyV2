package com.github.grangercarty.smogonusageapp;

import java.util.Objects;

/**
 * A class that handles the usage of an individual Pokemon in a metagame.
 */
public class SmogonPokemonUse {
    int rank;
    String pokemonName;
    String usageRate;

    /**
     * Takes a string of data, and creates a new SmogonPokemonUse object
     * @param smoUseLine - a String of data from a text file
     */
    public SmogonPokemonUse(String smoUseLine) {
        String[] stringArray = smoUseLine.split("\\|");
        this.rank = Integer.parseInt(stringArray[1].strip());
        this.pokemonName = stringArray[2].strip();
        this.usageRate = stringArray[3].strip();
    }

    /**
     * Ensures a line of a file is metagame usage data, and not something else
     * @param smogonUseLine - a String of data from a text file
     * @return true if smogonUseLine can be used to create a SmogonPokemonUse object, false otherwise
     */
    public static boolean isPokemonUse(String smogonUseLine) {
        String[] stringArray = smogonUseLine.split("\\|");
        return ( (stringArray.length > 3) && (stringArray[1].strip().matches("\\d+")) );
    }

    /**
     * @return A comma separated representation of the SmogonPokemonUse object
     */
    @Override
    public String toString() {
        return (rank + "," + pokemonName + "," + usageRate);
    }

    /**
     * Allows the SmogonPokemonUse object to be easily placed into an HTML table.
     * @return An HTML Table row representing the SmogonPokemonUse object
     */
    public String toHTMLTableRow() {
        return ("<tr><td>"+rank+"</td><td>"+pokemonName+"</td><td>"+usageRate+"</td></tr>\n");
    }

    /**
     * A getter for the rank.
     * @return An integer equal to the object's rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * A getter for the name.
     * @return A string equal to the object's name
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * A getter for the usage rate.
     * @return A string equal to the object's usage rate
     */
    public String getUsageRate() {
        return usageRate;
    }

    /**
     * Tests if another object is equal ot the SmogonPokemonUse object
     * @param o - another object
     * @return true if the object is a SmogonPokemonUse, and rank, pokemonName, and usageRate are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmogonPokemonUse that = (SmogonPokemonUse) o;
        return rank == that.rank && pokemonName.equals(that.pokemonName) && usageRate.equals(that.usageRate);
    }

    /**
     * A hashCode for the SmogonPokemonUse
     * @return An integer hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rank, pokemonName, usageRate);
    }
}
