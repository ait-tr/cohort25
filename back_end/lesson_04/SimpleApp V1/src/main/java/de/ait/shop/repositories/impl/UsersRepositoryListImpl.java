package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component("usersRepositoryList")
public class UsersRepositoryListImpl implements UsersRepository {

    private final List<User> users = new ArrayList<>(); // список пользователей
    private Long generatedId = 1L; // сгенерированный id для пользователя

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users); // просто возвращаем копию списка
    }

    @Override
    public void save(User user) {
        users.add(user); // положили пользователя в хранилище-список

        user.setId(generatedId); // задали этому пользователю идентификатор

        generatedId++; // значение сгенерированного идентификатора увеличили на 1 для следующего пользователя
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findOneByEmail(String email) {
//        for (User user : users) {
//            if (user.getEmail().equals(email)) {
//                return user;
//            }
//        }
//        return null;
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
