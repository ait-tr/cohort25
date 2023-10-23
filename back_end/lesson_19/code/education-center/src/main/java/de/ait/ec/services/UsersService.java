package de.ait.ec.services;

import de.ait.ec.dto.NewUserDto;
import de.ait.ec.dto.UserDto;
import de.ait.ec.dto.UsersPage;
import de.ait.ec.models.User;

import java.util.List;

public interface UsersService {
    UserDto register(NewUserDto newUser);

    UserDto getUserById(Long currentUserId);

    UsersPage getAllUsers(int page, int size, String orderBy, Boolean desc);

    List<UserDto> getUsersByCoursesPublished();

    List<UserDto> getUsersByCoursesNotStarted();
}
