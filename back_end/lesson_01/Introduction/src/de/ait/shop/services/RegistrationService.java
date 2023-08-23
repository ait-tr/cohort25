package de.ait.shop.services;

import de.ait.shop.models.User;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface RegistrationService {
    User register(String email, String password);
}
