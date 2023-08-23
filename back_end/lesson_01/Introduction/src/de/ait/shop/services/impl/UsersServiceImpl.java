package de.ait.shop.services.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.services.UsersService;

import java.util.List;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository; // зависимость на хранилище пользователей

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User addUser(String email, String password) {
        if (email == null || email.equals("") || email.equals(" ")) { // валидируем email
            throw new IllegalArgumentException("Email не может быть пустым");
        }

        if (password == null || password.equals("") || password.equals(" ")) { // валидируем password
            throw new IllegalArgumentException("Password не может быть пустым");
        }

        User existedUser = usersRepository.findOneByEmail(email); // находим пользователя по email

        if (existedUser != null) { // если такой пользователь уже есть
            throw new IllegalArgumentException("Пользователь с таким email уже есть");
        }

        User user = new User(email, password); // создаем пользователя

        usersRepository.save(user); // сохраняем пользователя в хранилище

        return user; // возвращаем пользователя как результат
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll(); // никакой дополнительной логики нет, просто запрашиваем у репозитория
    }
}
