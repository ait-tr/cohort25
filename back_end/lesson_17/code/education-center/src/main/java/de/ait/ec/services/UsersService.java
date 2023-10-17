package de.ait.ec.services;

import de.ait.ec.dto.NewUserDto;
import de.ait.ec.dto.UserDto;
import java.util.List;

public interface UsersService {
    UserDto register(NewUserDto newUser);

    UserDto getUserById(Long currentUserId);

    List<UserDto> getAllUsers();
}
