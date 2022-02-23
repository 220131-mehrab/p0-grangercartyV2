package com.github.grangercarty.smogonusageapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmogonPokemonUseTest {

    @Test
    public void isPokemonUseTest() {
        String poke = " | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ";
        String notPoke = " | Rank | Pokemon            | Usage %   | Raw    | %       | Real   | %       | ";
        Assertions.assertTrue(SmogonPokemonUse.isPokemonUse(poke));
        Assertions.assertFalse(SmogonPokemonUse.isPokemonUse((notPoke)));
    }

    @Test
    public void constructorAndGetterTest() {
        SmogonPokemonUse testPokeUse = new SmogonPokemonUse(" | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ");
        Assertions.assertEquals(17, testPokeUse.getRank());
        Assertions.assertEquals("Tapu Fini", testPokeUse.getPokemonName());
        Assertions.assertEquals("9.74931%", testPokeUse.getUsageRate());
    }

    @Test
    public void equalsTest() {
        SmogonPokemonUse testPokeUse1 = new SmogonPokemonUse(" | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ");
        SmogonPokemonUse testPokeUse2 = new SmogonPokemonUse(" | 17   | Tapu Fini          |  9.74931% | 199796 |  9.749% | 166642 | 10.385% | ");
        SmogonPokemonUse testPokeUse3 = new SmogonPokemonUse(" | 9    | Urshifu-Rapid-Strike | 11.73547% | 240499 | 11.735% | 188928 | 11.773% | ");
        Assertions.assertEquals(testPokeUse1, testPokeUse2);
        Assertions.assertNotEquals(testPokeUse1, testPokeUse3);
    }
}
