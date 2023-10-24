package de.ait.template.controllers;

import de.ait.template.controllers.api.UsersApi;
import de.ait.template.dto.NewUserDto;
import de.ait.template.dto.StandardResponseDto;
import de.ait.template.dto.UserDto;
import de.ait.template.security.details.AuthenticatedUser;
import de.ait.template.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


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
    public UserDto register(NewUserDto newUser) {
        return usersService.register(newUser);
    }

    @Override
    public UserDto getConfirmation(String confirmCode) {
        return usersService.confirm(confirmCode);
    }

    @Override
    public UserDto getProfile(AuthenticatedUser user) {
        Long currentUserId = user.getId();
        return usersService.getUserById(currentUserId);
    }
}
