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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

/**
 * 8/30/2023
 * SimpleApp
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Configuration
@ComponentScan(basePackages = "de.ait.shop")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
