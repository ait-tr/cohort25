package de.ait.shop.validation.impl;

import de.ait.shop.validation.EmailValidator;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class EmailNotEmptyValidatorImpl implements EmailValidator {
    @Override
    public void validate(String email) {
        if (email == null || email.equals("") || email.equals(" ")) {
            throw new IllegalArgumentException("Email не может быть пустым");
        }
    }
}
