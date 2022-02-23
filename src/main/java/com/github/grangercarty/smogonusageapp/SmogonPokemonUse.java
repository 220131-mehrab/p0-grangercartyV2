package com.github.grangercarty.smogonusageapp;

public class SmogonPokemonUse {
    String smogonUse;

    public SmogonPokemonUse(String smoUseLine) {
        this.smogonUse = smoUseLine;
    }

    @Override
    public String toString() {
        return smogonUse;
    }
}
