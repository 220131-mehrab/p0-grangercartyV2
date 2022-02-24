package com.github.grangercarty.smogonusageapp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SmogonUseServlet extends HttpServlet {
    SmogonUseService smoUseservice;

    public SmogonUseServlet(SmogonUseService service) {
        this.smoUseservice = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for (SmogonPokemonUse pokeUse : smoUseservice.getSmoUseRepo().getUsageList()) {
            resp.getWriter().println(pokeUse);
        }
    }
}
