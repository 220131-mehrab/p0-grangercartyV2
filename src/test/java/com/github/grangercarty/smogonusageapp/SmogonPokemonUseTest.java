package com.github.grangercarty.smogonusageapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A class that tests the SmogonPokemonUse class.
 */
public class SmogonPokemonUseTest {
    /**
     * A test that makes sure the isPokemonUse function is running properly.
     */
    @Test
    public void isPokemonUseTest() {
        String poke = " | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ";
        String notPoke = " | Rank | Pokemon            | Usage %   | Raw    | %       | Real   | %       | ";
        Assertions.assertTrue(SmogonPokemonUse.isPokemonUse(poke));
        Assertions.assertFalse(SmogonPokemonUse.isPokemonUse((notPoke)));
    }

    /**
     * A test that ensures instances of SmogonPokemonUse are being constructed properly, and internal values are set
     * properly.
     */
    @Test
    public void constructorAndGetterTest() {
        SmogonPokemonUse testPokeUse = new SmogonPokemonUse(" | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ");
        Assertions.assertEquals(17, testPokeUse.getRank());
        Assertions.assertEquals("Tapu Fini", testPokeUse.getPokemonName());
        Assertions.assertEquals("9.74931%", testPokeUse.getUsageRate());
    }

    /**
     * A test that ensures that two SmogonPokemonUse objects with equal internal variables are evaluated as equal,
     * and that two with different internal values are not equal.
     */
    @Test
    public void equalsTest() {
        SmogonPokemonUse testPokeUse1 = new SmogonPokemonUse(" | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ");
        SmogonPokemonUse testPokeUse2 = new SmogonPokemonUse(" | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ");
        SmogonPokemonUse testPokeUse3 = new SmogonPokemonUse(" | 9    | Urshifu-Rapid-Strike | 11.73547% | 240499 | 11.735% | 188928 | 11.773% | ");
        Assertions.assertEquals(testPokeUse1, testPokeUse2);
        Assertions.assertNotEquals(testPokeUse1, testPokeUse3);
    }
}
