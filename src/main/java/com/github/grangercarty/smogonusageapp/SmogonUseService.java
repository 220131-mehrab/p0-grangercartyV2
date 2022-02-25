package com.github.grangercarty.smogonusageapp;

public class SmogonUseService {
    protected SmogonUseRepo smoUseRepo;
    protected SmogonUseRepo currentRepo;

    public SmogonUseService(SmogonUseRepo smoUseRepo) {
        this.smoUseRepo = smoUseRepo;
        resetCurrent();
    }

    public void resetCurrent() {
        this.currentRepo = smoUseRepo;
    }

    public void getTopSmoUse(int i) {
        SmogonUseRepo updatedRepo = new SmogonUseRepo();
        for (SmogonPokemonUse pokeUse : currentRepo.getUsageList()) {
            if (pokeUse.getRank() <= i) {
                updatedRepo.addUse(pokeUse);
            }
        }
        currentRepo = updatedRepo;
    }

    public SmogonUseRepo getCurrentRepo() {
        return currentRepo;
    }
}
