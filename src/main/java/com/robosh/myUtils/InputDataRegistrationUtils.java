package com.robosh.myUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class that contains methods to manage data of registration
 *
 * @author Orest Shmelyuk
 */
public class InputDataRegistrationUtils {

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String CORRECT_PASSWORD = "[a-zA-Z0-9]{5,20}";
    private static final String CORRECT_NAME = "[a-zA-Z\\p{IsCyrillic}]{3,20}";
    private static final String CORRECT_PHONE_NUMBER = "^(\\+380)([0-9]{9})";

    private InputDataRegistrationUtils() {
    }

    private static boolean isCorrectEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password1, String password2) {
        Pattern validPassword = Pattern.compile(CORRECT_PASSWORD);
        Matcher matcher = validPassword.matcher(password1);
        return isSamePassword(password1, password2) && matcher.matches();
    }

    private static boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }

    private static boolean isCorrectName(String name) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_NAME);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(name);
        return matcher.matches();
    }

    private static boolean isCorrectSurname(String surname) {
        return isCorrectName(surname);
    }


    private static boolean isCorrectPhoneNumber(String phoneNumber) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_PHONE_NUMBER);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(phoneNumber);
        return matcher.matches();
    }

    private static boolean isCorrectNameSurname(String name, String surname) {
        return isCorrectName(name) && isCorrectSurname(surname);
    }

    public static boolean isNotCorrectData(String name, String surname, String phoneNumber,
                                           String email, String password, String repeatPassword) {
        return !(isCorrectNameSurname(name, surname) && isCorrectPhoneNumber(phoneNumber)
                && isCorrectEmail(email) && isValidPassword(password, repeatPassword));
    }
}
