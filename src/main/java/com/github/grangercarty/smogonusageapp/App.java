package com.github.grangercarty.smogonusageapp;

import java.util.Objects;

public class App {
    public static void main(String[] args) {
        String filename = "gen8ou_2022_01.txt";
        String file = Objects.requireNonNull(App.class.getClassLoader().getResource(filename)).getFile();
        System.out.println(file);
    }
}
