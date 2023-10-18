package de.ait.ec.services.impl;

import de.ait.ec.dto.NewUserDto;
import de.ait.ec.dto.UserDto;
import de.ait.ec.exceptions.RestException;
import de.ait.ec.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UsersServiceImpl usersService;

    @BeforeEach
    void setUp() {
        this.usersService = new UsersServiceImpl(usersRepository, passwordEncoder);


    }

    @Nested
    @DisplayName("register()")
    public class Register {

        @Test
        public void return_saved_new_user() {
            when(usersRepository.existsByEmail("user1@mail.com")).thenReturn(false);

            NewUserDto newUser = NewUserDto.builder()
                    .email("user1@mail.com")
                    .password("qwerty007")
                    .build();

            UserDto actual = usersService.register(newUser);

            UserDto expected = UserDto
                    .builder()
                    .role("USER")
                    .email("user1@mail.com")
                    .build();

            verify(passwordEncoder).encode("qwerty007");
            verify(usersRepository).save(any());

            assertEquals(expected, actual);
        }

        @Test
        public void throws_exception_for_exists_user() {
            when(usersRepository.existsByEmail("user@mail.com")).thenReturn(true);

            NewUserDto newUser = NewUserDto.builder()
                    .email("user@mail.com")
                    .password("qwerty007")
                    .build();

            assertThrows(RestException.class, () -> usersService.register(newUser));
        }
    }
}