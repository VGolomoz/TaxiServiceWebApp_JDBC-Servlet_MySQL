package com.robosh.web.command.account.driver;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return driver account
 *
 * @author Orest Shemelyuk
 */
public class DriverAccountCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(DriverAccountCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("return driver account");
        return RoutesJSP.DRIVER_ACCOUNT;
    }
}
