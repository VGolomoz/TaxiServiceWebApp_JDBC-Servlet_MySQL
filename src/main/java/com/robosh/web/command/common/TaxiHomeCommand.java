package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return home page jsp
 *
 * @author Orest Shemelyuk
 */
public class TaxiHomeCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(TaxiHomeCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("return taxi home page");
        return RoutesJSP.TAXI_HOME;
    }
}
