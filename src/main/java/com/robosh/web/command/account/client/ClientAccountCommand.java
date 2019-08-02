package com.robosh.web.command.account.client;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return client account page
 *
 * @author Orest Shemelyuk
 */
public class ClientAccountCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(ClientAccountCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("return client account page");
        return RoutesJSP.CLIENT_ACCOUNT;
    }
}
