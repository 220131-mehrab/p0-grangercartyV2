package com.github.grangercarty.smogonusageapp;

import java.util.Objects;

public class SmogonPokemonUse {
    int rank;
    String pokemonName;
    String usageRate;

    public SmogonPokemonUse(String smoUseLine) {
        String[] stringArray = smoUseLine.split("\\|");
        this.rank = Integer.parseInt(stringArray[1].strip());
        this.pokemonName = stringArray[2].strip();
        this.usageRate = stringArray[3].strip();
    }

    public static boolean isPokemonUse(String smogonUseLine) {
        String[] stringArray = smogonUseLine.split("\\|");
        return ( (stringArray.length > 3) && (stringArray[1].strip().matches("\\d+")) );
    }

    @Override
    public String toString() {
        return (rank + "," + pokemonName + "," + usageRate);
    }

    public String toHTMLTableRow() {
        return ("<tr><td>"+rank+"</td><td>"+pokemonName+"</td><td>"+usageRate+"</td></tr>\n");
    }

    public int getRank() {
        return rank;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getUsageRate() {
        return usageRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmogonPokemonUse that = (SmogonPokemonUse) o;
        return rank == that.rank && pokemonName.equals(that.pokemonName) && usageRate.equals(that.usageRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, pokemonName, usageRate);
    }
}
