package com.robosh.web.command.account.driver;


import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * shows all orders which has driver
 *
 * @author Orest Shemelyuk
 */
public class ShowAllDriverOrdersCommand implements Command {

    private OrderService orderService;

    private final Logger LOGGER = Logger.getLogger(ShowAllDriverOrdersCommand.class);
    private static final String PAGINATION_PARAMETER = "pagination";
    private static final String ORDER_LIST_ATTRIBUTE = "orderList";
    private static final String RECORD_PER_PAGE_ATTRIBUTE = "recordPerPage";
    private static final String PAGE_NUMBERS_ATTRIBUTE = "pageNumbers";

    public ShowAllDriverOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int idDriver = LoginedUserUtils.getLoginedUser(session).getPersonId();
        int pageNumber;
        int totalNumberRecords = (int) orderService.getAllOrdersCount(idDriver);
        int recordPerPage = 5;
        int startIndex;
        int numberOfPages;
        String sPageNo = request.getParameter(PAGINATION_PARAMETER);
        LOGGER.info("get number of page " + sPageNo);
        pageNumber = getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<Order> orderList = orderService.getAllOrderByIdDriver(idDriver, startIndex, recordPerPage);
        LOGGER.info("get lis Orders");
        request.setAttribute(ORDER_LIST_ATTRIBUTE, orderList);
        request.setAttribute(RECORD_PER_PAGE_ATTRIBUTE, recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }
        LOGGER.info("set request numberOfPages " + numberOfPages);
        request.setAttribute(PAGE_NUMBERS_ATTRIBUTE, numberOfPages);
        return RoutesJSP.SHOW_DRIVER_ORDERS;
    }

    private int getPageNumber(String strNumber) {
        try {
            return Integer.valueOf(strNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
