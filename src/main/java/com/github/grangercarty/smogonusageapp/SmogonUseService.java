package com.github.grangercarty.smogonusageapp;

public class SmogonUseService {
    SmogonUseRepo smoUseRepo;

    public SmogonUseService(SmogonUseRepo smoUseRepo) {
        this.smoUseRepo = smoUseRepo;
    }

    public void printAll() {
        for (SmogonPokemonUse pokeUse : smoUseRepo.getUsageList()) {
            System.out.println(pokeUse);
        }
    }

    public void printTop(int i) {
        for (SmogonPokemonUse pokeUse : smoUseRepo.getUsageList()) {
            if (pokeUse.getRank() <= i) {
                System.out.println(pokeUse);
            }
        }
    }
}
