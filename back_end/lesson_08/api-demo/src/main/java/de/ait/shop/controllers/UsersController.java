package de.ait.shop.controllers;

import de.ait.shop.dto.NewUserDto;
import de.ait.shop.dto.UpdateUserDto;
import de.ait.shop.dto.UserDto;
import de.ait.shop.models.User;
import de.ait.shop.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 9/6/2023
 * mvc-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(value = @Tag(name = "Users"))
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    @Operation(summary = "Получение всех пользователей", description = "Доступно всем пользователям")
    @GetMapping
    public List<UserDto> getAllUsers() {
        System.out.println(Thread.currentThread().getName());
        return usersService.getAllUsers();
    }

    @Operation(summary = "Добавление пользователя", description = "Доступно администратору системы")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody NewUserDto newUser) {
        return usersService.addUser(newUser);
    }

    @Operation(summary = "Получение одного пользователя", description = "Доступно всем пользователям")
    @GetMapping("/{user-id}") // users/10
    public UserDto getUser(@Parameter(description = "идентификатор пользователя", example = "4")
                           @PathVariable("user-id") Long id) {
        return usersService.getUser(id);
    }

    @Operation(summary = "Обновление пользователя", description = "Доступно только администратору")
    @PutMapping("/{user-id}")
    public UserDto updateUser(@Parameter(description = "идентификатор пользователя", example = "1")
                              @PathVariable("user-id") Long id,
                              @RequestBody UpdateUserDto updateUser) {
        return usersService.updateUser(id, updateUser);
    }

    @Operation(summary = "Удаление пользователя", description = "Доступно только администратору")
    @DeleteMapping("/{user-id}")
    public UserDto deleteUser(@Parameter(description = "идентификатор пользователя", example = "1")
                              @PathVariable("user-id") Long id) {
        return usersService.deleteUser(id);
    }
}
