package de.ait.shop.services;

import de.ait.shop.dto.NewUserDto;
import de.ait.shop.dto.UpdateUserDto;
import de.ait.shop.dto.UserDto;
import de.ait.shop.models.User;

import java.util.List;

/**
 * 8/23/2023
 * Introduction
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersService {
    List<UserDto> getAllUsers();

    UserDto addUser(NewUserDto newUser);

    UserDto getUser(Long id);

    UserDto updateUser(Long id, UpdateUserDto updateUser);

    UserDto deleteUser(Long id);
}
