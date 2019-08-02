package com.robosh.web.command.account.client;

import com.robosh.model.entity.Address;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.service.AddressService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * returns order page taxi
 *
 * @author Orest Shemelyuk
 */
public class ClientOrderCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(ClientOrderCommand.class);
    private static final String ALL_ADDRESS_ATTRIBUTE = "allAddress";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AddressService addressService = new AddressService();
        List<Address> allAddress = addressService.getAllAddress();
        request.setAttribute(ALL_ADDRESS_ATTRIBUTE, allAddress);
        LOGGER.info("set attribute all address and return taxi order page");
        return RoutesJSP.TAXI_ORDER;
    }
}
