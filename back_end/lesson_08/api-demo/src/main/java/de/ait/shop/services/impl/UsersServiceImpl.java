package de.ait.shop.services.impl;

import de.ait.shop.dto.NewUserDto;
import de.ait.shop.dto.UpdateUserDto;
import de.ait.shop.dto.UserDto;
import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static de.ait.shop.dto.UserDto.from;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository; // зависимость на хранилище пользователей

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto addUser(NewUserDto newUser) {
        // делаем модель на основе данных, которые пришли в сервис из DTO
        User user = User.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .build();

        usersRepository.save(user); // после save у user стоит id сгенерированный базой
        return from(user);
    }

    @Override
    public UserDto getUser(Long id) {
        return from(usersRepository.findById(id));
    }

    @Override
    public UserDto updateUser(Long id, UpdateUserDto updateUser) {
        // сначала получим пользователя, которого хотим обновить из базы данных
        User userForUpdate = usersRepository.findById(id);
        // кладем новые данные в эту модель (имя и фамилию)
        userForUpdate.setFirstName(updateUser.getFirstName());
        userForUpdate.setLastName(updateUser.getLastName());
        // делаем обновление через репозиторий
        usersRepository.update(userForUpdate);

        return from(userForUpdate);
    }

    @Override
    public UserDto deleteUser(Long id) {
        // получаем пользователя
        User forDelete = usersRepository.findById(id);
        // удаляем
        usersRepository.deleteById(id);
        // возвращаем пользователя
        return from(forDelete);
    }
}
