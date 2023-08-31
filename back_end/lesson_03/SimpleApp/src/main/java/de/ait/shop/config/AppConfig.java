package de.ait.shop.config;

import de.ait.shop.controllers.UsersController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.repositories.impl.UsersRepositoryFileImpl;
import de.ait.shop.repositories.impl.UsersRepositoryListImpl;
import de.ait.shop.services.UsersService;
import de.ait.shop.services.impl.UsersServiceImpl;
import de.ait.shop.validation.EmailValidator;
import de.ait.shop.validation.PasswordValidator;
import de.ait.shop.validation.impl.EmailNotEmptyValidatorImpl;
import de.ait.shop.validation.impl.EmailValidatorRegexImpl;
import de.ait.shop.validation.impl.PasswordNotEmptyValidatorImpl;
import de.ait.shop.validation.impl.PasswordValidatorRegexImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Configuration
public class AppConfig {

    @Bean
    public PasswordValidator passwordValidatorNotEmpty() {
        return new PasswordNotEmptyValidatorImpl();
    }

    @Bean
    public PasswordValidator passwordValidatorRegex() {
        return new PasswordValidatorRegexImpl();
    }

    @Bean
    public EmailValidator emailValidatorNotEmpty() {
        return new EmailNotEmptyValidatorImpl();
    }

    @Bean
    public EmailValidator emailValidatorRegex() {
        return new EmailValidatorRegexImpl();
    }

    @Bean
    public UsersRepository usersRepositoryList() {
        return new UsersRepositoryListImpl();
    }

    @Bean
    public UsersRepository usersRepositoryFile() {
        return new UsersRepositoryFileImpl("users.txt");
    }

    @Bean
    public UsersService usersService(UsersRepository usersRepositoryFile,
                                     EmailValidator emailValidatorNotEmpty,
                                     PasswordValidator passwordValidatorRegex) {
        return new UsersServiceImpl(usersRepositoryFile, emailValidatorNotEmpty, passwordValidatorRegex);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public UsersController usersController(Scanner scanner, UsersService usersService) {
        return new UsersController(scanner, usersService);
    }
}
