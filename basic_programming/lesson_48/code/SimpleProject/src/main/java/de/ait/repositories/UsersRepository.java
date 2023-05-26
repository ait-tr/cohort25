package de.ait.repositories;

import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
}
