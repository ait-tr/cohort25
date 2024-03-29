package de.ait.template.services;

import de.ait.template.dto.NewUserDto;
import de.ait.template.dto.StandardResponseDto;
import de.ait.template.dto.UserDto;
import de.ait.template.exceptions.RestException;
import de.ait.template.mail.MailTemplatesUtil;
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

    private final MailTemplatesUtil mailTemplatesUtil;

    @Value("${base.url}")
    private String baseUrl;

    @Transactional
    public UserDto register(NewUserDto newUser) {

        checkIfExistsByEmail(newUser);

        User user = saveNewUser(newUser);

        String codeValue = UUID.randomUUID().toString();

        saveConfirmCode(user, codeValue);

        String link = createLinkForConfirmation(codeValue);

        String html = mailTemplatesUtil.createConfirmationMail(user.getFirstName(), user.getLastName(), link);

        mailSender.send(user.getEmail(), "Registration", html); // @Async

        return from(user);
    }

    private String createLinkForConfirmation(String codeValue) {
        return baseUrl + "/confirm.html?id=" + codeValue;
    }

    private void saveConfirmCode(User user, String codeValue) {
        ConfirmationCode code = ConfirmationCode.builder()
                .code(codeValue)
                .user(user)
                .expiredDateTime(LocalDateTime.now().plusMinutes(1))
                .build();

        confirmationCodesRepository.save(code);
    }

    private User saveNewUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .state(User.State.NOT_CONFIRMED)
                .build();

        usersRepository.save(user);

        return user;
    }

    private void checkIfExistsByEmail(NewUserDto newUser) {
        if (usersRepository.existsByEmail(newUser.getEmail())) {
            throw new RestException(HttpStatus.CONFLICT,
                    "User with email <" + newUser.getEmail() + "> already exists");
        }
    }

    public UserDto getUserById(Long currentUserId) {
        return from(usersRepository.findById(currentUserId).orElseThrow());
    }

    @Transactional
    public UserDto confirm(String confirmCode) {
        ConfirmationCode code = confirmationCodesRepository
                .findByCodeAndExpiredDateTimeAfter(confirmCode, LocalDateTime.now())
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Code not found or is expired"));

        User user = usersRepository
                .findFirstByCodesContains(code)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "User by code not found"));

        user.setState(User.State.CONFIRMED);

        usersRepository.save(user);

        return UserDto.from(user);
    }
}
