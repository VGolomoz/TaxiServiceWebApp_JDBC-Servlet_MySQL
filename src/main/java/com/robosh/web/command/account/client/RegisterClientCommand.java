package com.robosh.web.command.account.client;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return page register client
 *
 * @author Orest Shemelyuk
 */
public class RegisterClientCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(RegisterClientCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("return register client page");
        return RoutesJSP.REGISTER_CLIENT;
    }
}
