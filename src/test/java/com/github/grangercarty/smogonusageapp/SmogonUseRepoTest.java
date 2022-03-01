package com.github.grangercarty.smogonusageapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A Class that tests the SmogonUseRepo class.
 */
public class SmogonUseRepoTest {

    /**
     * A test that ensures that a SmogonUseRepo is being set up properly.
     */
    @Test
    public void constructorAndGetterTest() {
        SmogonUseRepo testRepo = new SmogonUseRepo();
        testRepo.load("gen8ou_2022_01test.txt");
        SmogonPokemonUse poke1 = new SmogonPokemonUse(" | 1    | Landorus-Therian   | 30.46409% | 624311 | 30.464% | 539399 | 33.614% |");
        SmogonPokemonUse poke2 = new SmogonPokemonUse(" | 2    | Ferrothorn         | 19.65970% | 402893 | 19.660% | 348072 | 21.691% |");
        Assertions.assertEquals(poke1, testRepo.getUsageList().get(0));
        Assertions.assertEquals(poke2, testRepo.getUsageList().get(1));
    }
}
