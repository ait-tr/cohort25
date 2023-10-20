package de.ait.template.services;

import de.ait.template.dto.NewUserDto;
import de.ait.template.dto.UserDto;
import de.ait.template.exceptions.RestException;
import de.ait.template.models.User;
import de.ait.template.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static de.ait.template.dto.UserDto.from;

/**
 * 9/27/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDto register(NewUserDto newUser) {

        if (usersRepository.existsByEmail(newUser.getEmail())) {
            throw new RestException(HttpStatus.CONFLICT,
                    "User with email <" + newUser.getEmail() + "> already exists");
        }

        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .build();

        usersRepository.save(user);

        return from(user);
    }

    public UserDto getUserById(Long currentUserId) {
        return from(usersRepository.findById(currentUserId).orElseThrow());
    }
}
