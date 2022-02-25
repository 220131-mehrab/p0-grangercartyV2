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
        String userInput1 = req.getParameter("findTop");
        String userInput2 = req.getParameter("findName");
        smoUseservice.resetCurrent();
        if ( userInput1 != null && userInput1.matches("\\d+")) {
            smoUseservice.getTopSmoUse(Integer.parseInt(userInput1));
        }
        if ( userInput2 != null) {
            smoUseservice.genMonSmoUse(userInput2);
        }
        for (SmogonPokemonUse pokeUse : smoUseservice.getCurrentRepo().getUsageList()) {
            resp.getWriter().println(pokeUse);
        }
    }
}
