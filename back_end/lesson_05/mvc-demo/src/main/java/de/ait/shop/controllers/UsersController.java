package de.ait.shop.controllers;

import de.ait.shop.models.User;
import de.ait.shop.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 9/6/2023
 * mvc-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/signUp")
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password) {
        usersService.addUser(firstName, lastName, email, password);
        return "redirect:/success_signUp.html";
    }

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("usersList", users);

        return "users_page";
    }
}
