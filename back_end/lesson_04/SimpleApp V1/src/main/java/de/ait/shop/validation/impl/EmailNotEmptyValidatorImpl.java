package de.ait.shop.validation.impl;

import de.ait.shop.validation.EmailValidator;
import org.springframework.stereotype.Component;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component("emailNotEmptyValidator")
public class EmailNotEmptyValidatorImpl implements EmailValidator {
    @Override
    public void validate(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email не может быть пустым");
        }
    }
}
