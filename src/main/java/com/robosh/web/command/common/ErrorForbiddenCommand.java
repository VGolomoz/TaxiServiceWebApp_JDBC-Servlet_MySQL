package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return error page 403 forbidden
 *
 * @author Orest Shemelyuk
 */
public class ErrorForbiddenCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(ErrorForbiddenCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("return 403 page");
        return RoutesJSP.HTTP_FORBIDDEN;
    }
}
