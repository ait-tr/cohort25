package de.ait.shop.controllers;

import de.ait.shop.dto.NewUserDto;
import de.ait.shop.dto.UserDto;
import de.ait.shop.models.User;
import de.ait.shop.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 9/6/2023
 * mvc-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(value = @Tag(name = "Users"))
@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

    @Operation(summary = "Получение всех пользователей", description = "Доступно администратору системы")
    @GetMapping("/users")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @Operation(summary = "Добавление пользователя", description = "Доступно администратору системы")
    @PostMapping("/users")
    @ResponseBody
    public UserDto addUser(@RequestBody NewUserDto newUser) {
        return usersService.addUser(newUser);
    }
}
