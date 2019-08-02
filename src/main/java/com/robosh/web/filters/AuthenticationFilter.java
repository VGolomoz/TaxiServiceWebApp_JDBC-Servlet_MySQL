package com.robosh.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.robosh.model.entity.Person;
import com.robosh.model.entity.enums.Role;
import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.myUtils.SecurityUtils;
import org.apache.log4j.Logger;

import static com.robosh.web.command.PathCommand.*;

public class AuthenticationFilter implements Filter {
    private final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig fConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String pathInfo = request.getPathInfo();
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        Person loginedPerson = LoginedUserUtils.getLoginedUser(request.getSession());
        LOGGER.info("get all info in do Filter");
        if ((LOGIN_PAGE.equals(pathInfo) || REGISTER_CLIENT.equals(pathInfo)) && loginedPerson != null) {
            if (loginedPerson.getRole().equals(Role.CLIENT)) {
                LOGGER.info("role = Client, return client account");
                response.sendRedirect(contextAndServletPath + CLIENT_ACCOUNT);
            } else {
                LOGGER.info("role = Driver, return driver account");
                response.sendRedirect(contextAndServletPath + DRIVER_ACCOUNT);
            }
            return;
        }
        LOGGER.info("check if page is secure");
        if (SecurityUtils.isSecurityPage(request)) {
            if (loginedPerson != null && SecurityUtils.hasPermission(request, loginedPerson.getRole())) {
                LOGGER.info("person has access to this page");
                chain.doFilter(req, resp);
            } else {
                if (MAKE_ORDER.equals(pathInfo)) {
                    LOGGER.info("redirect to login");
                    response.sendRedirect(contextAndServletPath + LOGIN_PAGE);
                } else {
                    LOGGER.info("redirect to 403");
                    response.sendRedirect(contextAndServletPath + FORBIDDEN);
                }
            }
        } else {
            LOGGER.info("page is not secure, doFilter");
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}