package de.ait.ec.services.impl;

import de.ait.ec.dto.NewUserDto;
import de.ait.ec.dto.UserDto;
import de.ait.ec.dto.UsersPage;
import de.ait.ec.exceptions.RestException;
import de.ait.ec.models.User;
import de.ait.ec.repositories.UsersRepository;
import de.ait.ec.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.ec.dto.UserDto.from;

/**
 * 9/27/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto register(NewUserDto newUser) {

        if (usersRepository.existsByEmail(newUser.getEmail())) {
            throw new RestException(HttpStatus.CONFLICT,
                    "User with email <" + newUser.getEmail() + "> already exists");
        }

        User user = User.builder()
                .email(newUser.getEmail())
                .password(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .build();

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UserDto getUserById(Long currentUserId) {
        return from(usersRepository.findById(currentUserId).orElseThrow());
    }

    @Override
    public UsersPage getAllUsers(int page, int size, String orderBy, Boolean desc) {

        Sort sort = Sort.by(orderBy);

        if (desc != null && desc) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort); // запрос на получение данных с пагинацией и сортировкой

        Page<User> pageResult = usersRepository.findAll(pageRequest);

        return UsersPage
                .builder()
                .users(from(pageResult.getContent()))
                .totalPages(pageResult.getTotalPages())
                .build();
    }

    @Override
    public List<UserDto> getUsersByCoursesPublished() {
        List<User> users = usersRepository.findAllByCoursesPublished();

        return from(users);
    }

    @Override
    public List<UserDto> getUsersByCoursesNotStarted() {
        List<User> users = usersRepository.findAllByCoursesPublished();

        return from(users);
    }
}
