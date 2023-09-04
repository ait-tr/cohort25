package de.ait.shop.validation.impl;

import de.ait.shop.validation.EmailValidator;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component("emailValidatorRegex")
public class EmailValidatorRegexImpl implements EmailValidator {

    private static final String REGEX = "^(?=.{1,256}$)[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]" +
            "+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[A-Za-z0-9]" +
            "(?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z]{2,}$";
    @Override
    public void validate(String email) {
        Pattern pattern = Pattern.compile(REGEX); // создаем "шаблон" по регулярному выражение
        Matcher matcher = pattern.matcher(email); // создаем объект,
        // который проверяет совпадение регулярного выражения (pattern-а) c вашей строкой email
        if (!matcher.matches()) { // если совпадения между регулярным выражением и строкой нет
            throw new IllegalArgumentException("Email не соответствует формату");
        }
    }
}
