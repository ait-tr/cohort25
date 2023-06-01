package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {

    private List<User> users = new ArrayList<>(List.of(
            new User("Marsel", "Sidikov", 29, 1.85),
            new User("Maxim", "Ivanov", 19, 1.79),
            new User("Ruslan", "Kochkin", 41, 1.83),
            new User("Kirill", "Petrov", 55, 1.90),
        new User("Anna", "Petrova", 54, 1.55)
    ));

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
