package com.robosh.web.command;

public interface PathCommand {
    String REGISTER_CLIENT = "/registerClient";
    String REGISTER_PAGE = "/register";
    String HOME_PAGE = "/homePage";
    String MAKE_ORDER = "/makeOrder";
    String ENTER_LOGIN = "/enterLogin";
    String LOGIN_PAGE = "/login";
    String LOGOUT = "/logOut";
    String CLIENT_ACCOUNT = "/clientAccount";
    String DRIVER_ACCOUNT = "/driverAccount";
    String SHOW_ALL_ORDERS_PAG = "/showAllOrders";
    String FORBIDDEN = "/forbidden";
    String ENTER_ORDER = "/enterOrder";
    String SHOW_CLIENT_ORDER = "/showClientOrder";
    String ENTER_NUMBER_OF_ORDER = "/enterNumOrder";
    String REDIRECT = "redirect#";
    String EMPTY_STR = "";
}
