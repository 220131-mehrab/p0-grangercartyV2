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

    public void genMonSmoUse(String name) {
        SmogonUseRepo updatedRepo = new SmogonUseRepo();
        for (SmogonPokemonUse pokeUse : currentRepo.getUsageList()) {
            if (pokeUse.getPokemonName().toLowerCase().contains(name.toLowerCase())) {
                updatedRepo.addUse(pokeUse);
            }
        }
        currentRepo = updatedRepo;
    }

    public SmogonUseRepo getCurrentRepo() {
        return currentRepo;
    }

    public static String getHTMLSearchForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>New Smogon Use Search</h1>\n");
        stringBuilder.append("<form action='smogonUse' method='get'>\n");
        stringBuilder.append("<label for='topNum'>Ranked in top:</label><br>\n");
        stringBuilder.append("<input type='text' id='topNum' name='getTop'><br>\n");
        stringBuilder.append("<label for='name'>Pokemon name contains:</label><br>\n");
        stringBuilder.append("<input type='text' id='name' name='getName'><br>\n");
        stringBuilder.append("<input type='submit' value='I CHOOSE YOU'><br>\n");
        stringBuilder.append("</form>\n");
        return stringBuilder.toString();
    }
}
