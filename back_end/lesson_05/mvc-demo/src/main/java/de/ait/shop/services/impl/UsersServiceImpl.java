package de.ait.shop.services.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository; // зависимость на хранилище пользователей


    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User addUser(String firstName, String lastName, String email, String password) { // метод добавления пользователя

        User user = new User(firstName, lastName, email, password); // создаем пользователя

        usersRepository.save(user); // сохраняем пользователя в хранилище

        return user; // возвращаем пользователя как результат
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll(); // никакой дополнительной логики нет, просто запрашиваем у репозитория
    }
}
