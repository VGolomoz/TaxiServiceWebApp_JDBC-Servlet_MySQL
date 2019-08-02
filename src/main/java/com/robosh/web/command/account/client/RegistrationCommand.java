package com.robosh.web.command.account.client;


import com.robosh.myUtils.InputDataRegistrationUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.service.ClientService;
import org.apache.log4j.Logger;

import static com.robosh.web.command.PathCommand.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * takes parameter from jsp page and registers
 * Client in system
 *
 * @author Orest Shemelyuk
 */
public class RegistrationCommand implements Command {
    private static final String NAME_PARAMETER = "name";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String PHONE_NUMBER_PARAMETER = "phone_number";
    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String PASSWORD_REPEAT = "password_repeat";
    private static final String BAD_INPUT = "?badInput=true";
    private static final String BAD_EMAIL = "?badEmail=true";
    private static final String BAD_PHONE = "?badPhoneNumber=true";
    private final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
    private ClientService clientService;

    public RegistrationCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        final String name = request.getParameter(NAME_PARAMETER);
        final String surname = request.getParameter(SURNAME_PARAMETER);
        final String phoneNumber = request.getParameter(PHONE_NUMBER_PARAMETER);
        final String email = request.getParameter(EMAIL_PARAMETER);
        final String password = request.getParameter(PASSWORD_PARAMETER);
        final String repeatPassword = request.getParameter(PASSWORD_REPEAT);

        if (name == null) {
            LOGGER.info("Name == null, return register client");
            return RoutesJSP.REGISTER_CLIENT;
        }
        if (InputDataRegistrationUtils.isNotCorrectData(name, surname, phoneNumber,
                email, password, repeatPassword)) {
            LOGGER.info("wrong data input");
            return RoutesJSP.REGISTER_CLIENT + BAD_INPUT;
        }

        Client client = new Client();
        client.setName(name);
        client.setPhoneNumber(phoneNumber);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPassword(password);

        try {
            LOGGER.info("try write to database client");
            clientService.createClientInDatabase(client);
        } catch (EmailIsAlreadyTaken emailIsAlreadyTaken) {
            LOGGER.error("EmailIsAlreadyTaken ", emailIsAlreadyTaken);
            emailIsAlreadyTaken.printStackTrace();
            return RoutesJSP.REGISTER_CLIENT + BAD_EMAIL;
        } catch (PhoneNumberIsAlreadyTaken phoneNumberIsAlreadyTaken) {
            LOGGER.error("PhoneNumberIsAlreadyTaken ", phoneNumberIsAlreadyTaken);
            phoneNumberIsAlreadyTaken.printStackTrace();
            return RoutesJSP.REGISTER_CLIENT + BAD_PHONE;
        }

        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        LOGGER.info("return login page");
        return REDIRECT + contextAndServletPath + LOGIN_PAGE;
    }
}
