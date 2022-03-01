package com.github.grangercarty.smogonusageapp;

public class SmogonUseService {
    protected SmogonUseRepo smoUseRepo;
    protected SmogonUseRepo currentRepo;

    /**
     * Creates a new SmogonUseService using a SmogonUseRepo.
     * @param smoUseRepo - The repo the new service will work with
     */
    public SmogonUseService(SmogonUseRepo smoUseRepo) {
        this.smoUseRepo = smoUseRepo;
        resetCurrent();
    }

    /**
     * As the source repo should not change once set, resets the current repo to the source.
     */
    public void resetCurrent() {
        this.currentRepo = smoUseRepo;
    }

    /**
     * Changes the currentRepo to only contain Pokemon with a rank value below a specified value.
     * @param i - The maximum value a Pokemon should be ranked.
     */
    public void getTopSmoUse(int i) {
        SmogonUseRepo updatedRepo = new SmogonUseRepo();
        for (SmogonPokemonUse pokeUse : currentRepo.getUsageList()) {
            if (pokeUse.getRank() <= i) {
                updatedRepo.addUse(pokeUse);
            }
        }
        currentRepo = updatedRepo;
    }

    /**
     * Changes the currentRepo to only contain Pokemon with a name containing a specified string.
     * @param name - A string that a Pokemon should contain in its name
     */
    public void genMonSmoUse(String name) {
        SmogonUseRepo updatedRepo = new SmogonUseRepo();
        for (SmogonPokemonUse pokeUse : currentRepo.getUsageList()) {
            if (pokeUse.getPokemonName().toLowerCase().contains(name.toLowerCase())) {
                updatedRepo.addUse(pokeUse);
            }
        }
        currentRepo = updatedRepo;
    }

    /**
     * A getter that returns the current Repo.
     * @return The current repo
     */
    public SmogonUseRepo getCurrentRepo() {
        return currentRepo;
    }

    /**
     * A static method that generates a search form for HTML.
     * @return An HTML search form
     */
    public static String getHTMLSearchForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>New Smogon Use Search</h1>\n");
        stringBuilder.append("<form action='smogonUse' method='get'>\n");
        stringBuilder.append("<label for='topNum'>Ranked in top:</label><br>\n");
        stringBuilder.append("<input type='text' id='topNum' name='getTop'><br>\n");
        stringBuilder.append("<label for='name'>Pokemon name contains:</label><br>\n");
        stringBuilder.append("<input type='text' id='name' name='getName'><br>\n");
        stringBuilder.append("<input type='submit' value='I CHOOSE YOU!'><br>\n");
        stringBuilder.append("</form>\n");
        return stringBuilder.toString();
    }
}
