package de.ait.shop.services.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.services.UsersService;
import de.ait.shop.validation.EmailValidator;
import de.ait.shop.validation.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
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

    private final EmailValidator emailValidator; // зависимость на валидатор email-ов

    private final PasswordValidator passwordValidator; // зависимость на валидатор паролей

    public UsersServiceImpl(UsersRepository usersRepository,
                            EmailValidator emailValidator,
                            PasswordValidator passwordValidator) {
        this.usersRepository = usersRepository;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public User addUser(String email, String password) { // метод добавления пользователя
        emailValidator.validate(email);

        passwordValidator.validate(password);

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

    @Override
    public void updateUser(Long id, String newEmail, String newPassword) {
        // сначала нужно получить этого пользователя по его id

        // вариант примитивный - воспользоваться уже существующим методом findAll
        List<User> users = usersRepository.findAll(); // получаем всех пользователей из базы

        // находим в этом списке нужного нам пользователя
        User userForUpdate = null;

        // пробегаем весь список
        for (User user : users) {
            // если у пользователя из списка id совпал с тем, который мы хотим обновить
            if (user.getId().equals(id)) {
                // запоминаем этого пользователя
                userForUpdate = user;
                // останавливаем цикл
                break;
            }
        }

        // если пользователя так и не нашли, нужно выбросить ошибку
        if (userForUpdate == null) {
            throw new IllegalArgumentException("User with id <" + id + "> not found");
        }

        // проверим, корректные ли данные на обновление и если они корректные, то дадим пользователю новые данные
        if (!newEmail.isBlank()) { // если не пустой
            // если пользователь не указал email как пробелы (он реально его хочет обновить)
            userForUpdate.setEmail(newEmail); // положили новый email
        }

        if (!newPassword.isBlank()) {
            userForUpdate.setPassword(newPassword);
        }

        // обновить данные в файле
        usersRepository.update(userForUpdate); // просто передаем обновленного пользователя в репозиторий

    }
}
