package com.robosh.web;

import com.robosh.web.command.Command;
import com.robosh.service.*;

import static com.robosh.web.command.PathCommand.*;

import com.robosh.web.command.account.client.*;
import com.robosh.web.command.account.driver.DriverAccountCommand;
import com.robosh.web.command.account.driver.DriverEnterNumberOrderCommand;
import com.robosh.web.command.account.driver.EnterLoginCommand;
import com.robosh.web.command.account.driver.ShowAllDriverOrdersCommand;
import com.robosh.web.command.common.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is main Servlet that process all pages
 *
 * @author Orest Shemelyuk
 */
public class Servlet extends HttpServlet {
    private final Logger LOGGER = Logger.getLogger(Servlet.class);
    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        LOGGER.info("put all commands in HashMap");
        commands.put(REGISTER_CLIENT, new RegisterClientCommand());
        commands.put(REGISTER_PAGE, new RegistrationCommand(new ClientService()));
        commands.put(HOME_PAGE, new TaxiHomeCommand());
        commands.put(MAKE_ORDER, new ClientOrderCommand());
        commands.put(ENTER_LOGIN, new EnterLoginCommand(new ClientService(), new DriverService()));
        commands.put(LOGIN_PAGE, new LoginCommand());
        commands.put(LOGOUT, new LogOutCommand());
        commands.put(CLIENT_ACCOUNT, new ClientAccountCommand());
        commands.put(DRIVER_ACCOUNT, new DriverAccountCommand());
        commands.put(SHOW_ALL_ORDERS_PAG, new ShowAllDriverOrdersCommand(new OrderService()));
        commands.put(FORBIDDEN, new ErrorForbiddenCommand());
        commands.put(ENTER_ORDER, new EnterOrderCommand(new OrderService(), new DriverService(),
                new AddressService(), new CouponService()));
        commands.put(SHOW_CLIENT_ORDER, new ShowOrderClientCommand());
        commands.put(ENTER_NUMBER_OF_ORDER, new DriverEnterNumberOrderCommand(new OrderService()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("doGet process");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("doPost process");
        processRequest(request, response);
    }

    /**
     * this method process requests and
     * get path to the next page from Command interface
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandKey = getRequestPath(request);
        LOGGER.info("get command");
        Command command = commands.get(commandKey);
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        if (command == null) {
            LOGGER.info("command is null redirect home page");
            response.sendRedirect(contextAndServletPath + HOME_PAGE);
        } else {
            String nextPage = command.execute(request, response);
            if (isRedirect(nextPage)) {
                LOGGER.info("redirect page " + nextPage);
                response.sendRedirect(nextPage.replaceAll(REDIRECT, EMPTY_STR));
            } else {
                LOGGER.info("forward page " + nextPage);
                request.getRequestDispatcher(nextPage).forward(request, response);
            }
        }
    }

    private String getRequestPath(HttpServletRequest request) {
        String pathURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String regex = ".*" + servletPath;
        return pathURI.replaceAll(regex, EMPTY_STR);
    }

    private boolean isRedirect(String string) {
        return string.contains(REDIRECT);
    }
}
