package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.PathCommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * destroy session adn logout from account
 *
 * @author Orest Shemelyuk
 */
public class LogOutCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        LOGGER.info("destroy session");
        session.invalidate();
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        LOGGER.info("return home page");
        return PathCommand.REDIRECT + contextAndServletPath + PathCommand.HOME_PAGE;
    }
}
