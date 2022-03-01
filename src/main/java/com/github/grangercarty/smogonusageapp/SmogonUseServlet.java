package com.github.grangercarty.smogonusageapp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SmogonUseServlet extends HttpServlet {
    SmogonUseService smoUseService;

    /**
     * A constructor for a servlet using a given service.
     * @param service - A PokemonUseService
     */
    public SmogonUseServlet(SmogonUseService service) {
        this.smoUseService = service;
    }

    /**
     * An override method that inputs and outputs data through the servlet.
     * @param req - The incoming HTTPServlet request
     * @param resp - A HTTPServlet response
     * @throws IOException - Tomcat handles this
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userInput1 = req.getParameter("getTop");
        String userInput2 = req.getParameter("getName");
        smoUseService.resetCurrent();
        resp.getWriter().println(SmogonUseService.getHTMLSearchForm());

        if ( userInput1 != null && userInput1.matches("\\d+")) {
            smoUseService.getTopSmoUse(Integer.parseInt(userInput1));
        }
        if ( userInput2 != null) {
            smoUseService.genMonSmoUse(userInput2);
        }
        resp.getWriter().print(smoUseService.getCurrentRepo().getUsageListAsHTMLTable());
    }
}
