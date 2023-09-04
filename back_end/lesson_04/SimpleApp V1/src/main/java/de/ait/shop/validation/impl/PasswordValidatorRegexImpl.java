package de.ait.shop.validation.impl;

import de.ait.shop.validation.PasswordValidator;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component("passwordValidatorRegex")
public class PasswordValidatorRegexImpl implements PasswordValidator {

    private static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

    @Override
    public void validate(String password) {
        Pattern pattern = Pattern.compile(REGEX); // создаем шаблон
        Matcher matcher = pattern.matcher(password); // создаем проверяльщика

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Пароль слабый");
        }
    }
}
