package de.ait.template.services;

import de.ait.template.dto.NewUserDto;
import de.ait.template.dto.StandardResponseDto;
import de.ait.template.dto.UserDto;
import de.ait.template.exceptions.RestException;
import de.ait.template.mail.TemplateProjectMailSender;
import de.ait.template.models.ConfirmationCode;
import de.ait.template.models.User;
import de.ait.template.repositories.ConfirmationCodesRepository;
import de.ait.template.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

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

    private final ConfirmationCodesRepository confirmationCodesRepository;

    private final PasswordEncoder passwordEncoder;

    private final TemplateProjectMailSender mailSender;

    @Value("${base.url}")
    private String baseUrl;

    @Transactional
    public UserDto register(NewUserDto newUser) {

        if (usersRepository.existsByEmail(newUser.getEmail())) {
            throw new RestException(HttpStatus.CONFLICT,
                    "User with email <" + newUser.getEmail() + "> already exists");
        }

        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED)
                .build();

        usersRepository.save(user);

        String codeValue = UUID.randomUUID().toString();

        ConfirmationCode code = ConfirmationCode.builder()
                .code(codeValue)
                .user(user)
                .expiredDateTime(LocalDateTime.now().plusMinutes(1))
                .build();

        confirmationCodesRepository.save(code);

        mailSender.send(user.getEmail(), "Registration", "<a href='" + baseUrl + "/api/users/confirm/" + codeValue + "'>Confirm Registration</a>"); // @Async

        return from(user);
    }

    public UserDto getUserById(Long currentUserId) {
        return from(usersRepository.findById(currentUserId).orElseThrow());
    }

    @Transactional
    public StandardResponseDto confirm(String confirmCode) {
        ConfirmationCode code = confirmationCodesRepository
                .findByCodeAndExpiredDateTimeAfter(confirmCode, LocalDateTime.now())
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Code not found or is expired"));

        User user = usersRepository
                .findFirstByCodesContains(code)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "User by code not found"));

        user.setState(User.State.CONFIRMED);

        usersRepository.save(user);

        return StandardResponseDto.builder()
                .message("User confirmed")
                .build();
    }

    public void send(StandardResponseDto body) {
        mailSender.send("100polok2018@gmail.com", "some", body.getMessage());
    }
}
