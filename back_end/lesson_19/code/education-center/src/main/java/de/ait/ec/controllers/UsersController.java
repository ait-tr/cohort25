package de.ait.ec.controllers;

import de.ait.ec.controllers.api.UsersApi;
import de.ait.ec.dto.NewUserDto;
import de.ait.ec.dto.UserDto;
import de.ait.ec.dto.UsersPage;
import de.ait.ec.models.User;
import de.ait.ec.security.details.AuthenticatedUser;
import de.ait.ec.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 9/27/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public UsersPage getAllUsers(int page, int size, String orderBy, Boolean desc) {
        return usersService.getAllUsers(page, size, orderBy, desc);
    }

    @Override
    public UserDto register(NewUserDto newUser) {
        return usersService.register(newUser);
    }

    @Override
    public UserDto getProfile(AuthenticatedUser  user) {
        Long currentUserId = user.getId();
        return usersService.getUserById(currentUserId);
    }

    @Override
    public List<UserDto> getByCoursesPublished() {
        return usersService.getUsersByCoursesPublished();
    }

    @Override
    public List<UserDto> getUsersByCoursesNotStarted() {
        return usersService.getUsersByCoursesNotStarted();
    }
}
