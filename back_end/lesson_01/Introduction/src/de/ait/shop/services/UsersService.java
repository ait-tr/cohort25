package de.ait.shop.services;

import de.ait.shop.models.User;

import java.util.List;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersService {
    User addUser(String email, String password);

    List<User> getAllUsers();
}
