package com.robosh.myUtils;

import com.robosh.model.entity.Person;

import javax.servlet.http.HttpSession;

/**
 * class that save logined users in session and return them
 */
public class LoginedUserUtils {

    private static final String SESSION_ATTRIBUTE = "loginedPerson";

    public static void storeLoginedUser(HttpSession session, Person loginedPerson) {
        session.setAttribute(SESSION_ATTRIBUTE, loginedPerson);
    }

    public static Person getLoginedUser(HttpSession session) {
        return (Person) session.getAttribute(SESSION_ATTRIBUTE);
    }

    public static void updateLoginedUser(HttpSession session, Person loginedPerson) {
        session.removeAttribute(SESSION_ATTRIBUTE);
        session.setAttribute(SESSION_ATTRIBUTE, loginedPerson);
    }
}
