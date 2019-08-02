package com.robosh.web.command.account.driver;

import com.robosh.model.entity.enums.Role;
import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.web.command.Command;

import static com.robosh.web.command.PathCommand.*;

import com.robosh.web.command.RoutesJSP;
import com.robosh.model.entity.Person;
import com.robosh.service.ClientService;
import com.robosh.service.DriverService;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this class respond for taking register parameters and register
 * client with such parameter
 *
 * @author Orest Shemelyuk
 */
public class EnterLoginCommand implements Command {

    private ClientService clientService;
    private DriverService driverService;

    private static final String PHONE_PARAMETER = "phoneNumber";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String ERROR_MESSAGE_STRING = "Invalid Phone Number or Password";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
    private static final String WRONG_DATA = "?wrongData=true";
    private final Logger LOGGER = Logger.getLogger(EnterLoginCommand.class);


    public EnterLoginCommand(ClientService clientService, DriverService driverService) {
        this.clientService = clientService;
        this.driverService = driverService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final String phoneNumber = request.getParameter(PHONE_PARAMETER);
        final String password = request.getParameter(PASSWORD_PARAMETER);
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        LOGGER.info("check data phone number and password" + phoneNumber + " " + password);
        if (inputWrongData(phoneNumber, password)) {
            request.setAttribute(ERROR_MESSAGE_ATTRIBUTE, ERROR_MESSAGE_STRING);
            LOGGER.info("wrong data");
            return RoutesJSP.LOGIN + WRONG_DATA;
        } else {
            Person person = LoginedUserUtils.getLoginedUser(request.getSession());
            if (person != null) {
                LOGGER.info("person id not null");
                if (Role.CLIENT.toString().equals(person.getRole().toString())) {
                    LOGGER.info("return client account");
                    return REDIRECT + contextAndServletPath + CLIENT_ACCOUNT;
                } else {
                    LOGGER.info("return driver account");
                    return REDIRECT + contextAndServletPath + DRIVER_ACCOUNT;
                }
            }
            if (checkIfDriver(phoneNumber, password)) {
                LOGGER.info("return driver account");
                person = driverService.getDriverByPasswordAndPhone(phoneNumber, password);
                LoginedUserUtils.storeLoginedUser(request.getSession(), person);
                return REDIRECT + contextAndServletPath + DRIVER_ACCOUNT;
            } else {
                LOGGER.info("return client account");
                person = clientService.getClientByPasswordAndPhone(phoneNumber, password);
                LoginedUserUtils.storeLoginedUser(request.getSession(), person);
                return REDIRECT + contextAndServletPath + CLIENT_ACCOUNT;
            }
        }
    }

    private boolean inputWrongData(String phoneNumber, String password) {
        return !checkIfClient(phoneNumber, password) && !checkIfDriver(phoneNumber, password);
    }

    private boolean checkIfClient(String phoneNumber, String password) {
        return clientService.isClientAlreadyExist(phoneNumber, password);
    }

    private boolean checkIfDriver(String phoneNumber, String password) {
        return driverService.isDriverExists(phoneNumber, password);
    }
}
