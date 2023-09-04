package de.ait.shop.validation.impl;

import de.ait.shop.validation.PasswordValidator;
import org.springframework.stereotype.Component;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component("passwordNotEmptyValidator")
public class PasswordNotEmptyValidatorImpl implements PasswordValidator {

    @Override
    public void validate(String password) {
        if (password == null || password.isBlank()) { // валидируем password
            throw new IllegalArgumentException("Password не может быть пустым");
        }
    }
}
