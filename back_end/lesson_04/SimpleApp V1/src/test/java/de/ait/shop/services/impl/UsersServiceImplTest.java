package de.ait.shop.services.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.validation.EmailValidator;
import de.ait.shop.validation.PasswordValidator;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("UsersServiceImpl is works ...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class UsersServiceImplTest {

    private static final String EXIST_USER_EMAIL = "user@gmail.com";
    private static final String NOT_EXIST_USER_EMAIL = "marsel@gmail.com";
    private static final String DEFAULT_PASSWORD = "qwerty007";
    private static final User NOT_EXIST_USER = new User(NOT_EXIST_USER_EMAIL, DEFAULT_PASSWORD);
    private static final User EXIST_USER = new User(EXIST_USER_EMAIL, DEFAULT_PASSWORD);


    private UsersServiceImpl usersService; // объект, который мы будем тестировать

    private UsersRepository usersRepository;
    private EmailValidator emailValidator;
    private PasswordValidator passwordValidator;

    // сначала нужно этот объект создать/подготовить

    @BeforeEach
    public void setUp() {
        // мы просим Mockito сделать объект, который будет иметь тип UserRepository
        usersRepository = Mockito.mock(UsersRepository.class);

        emailValidator = Mockito.mock(EmailValidator.class);
        passwordValidator = Mockito.mock(PasswordValidator.class);

        // явно прописываем поведение методов на конкретных данных

        // stubbing
        // когда у userRepository вызываем findOneByEmail с аргументом user@gmail.com возвращается пользователь с емейлом и паролем
        when(usersRepository.findOneByEmail(EXIST_USER_EMAIL)).thenReturn(EXIST_USER);
        // когда у usersRepository вызываем findOneByEmail с аргументом marsel@gmail.com возвращается null
        when(usersRepository.findOneByEmail(NOT_EXIST_USER_EMAIL)).thenReturn(null);
        // когда у emailValidator вызывают validate на пустом email (это void метод)
        doThrow(IllegalArgumentException.class).when(emailValidator).validate(null);
        doThrow(IllegalArgumentException.class).when(passwordValidator).validate(" ");

        this.usersService = new UsersServiceImpl(usersRepository, emailValidator, passwordValidator);
    }

    @Nested
    @DisplayName(("addUser():"))
    class AddUser {
        @Test
        public void on_incorrect_email_throws_exception() {
            // указываем тип ожидаемой ошибки через class
            assertThrows(IllegalArgumentException.class, () -> usersService.addUser(null, DEFAULT_PASSWORD));
        }

        @Test
        public void on_incorrect_password_throws_exception() {
            // указываем тип ожидаемой ошибки через class
            assertThrows(IllegalArgumentException.class, () -> usersService.addUser("sidikov.marsel@gmail.com", " "));
        }

        @Test
        public void on_existed_user_throws_exception() {
            assertThrows(IllegalArgumentException.class, () -> usersService.addUser(EXIST_USER_EMAIL, DEFAULT_PASSWORD));
        }

        @Test
        public void returns_created_user() {
            User actual = usersService.addUser(NOT_EXIST_USER_EMAIL, DEFAULT_PASSWORD); // на вход подаем пользователя без id

            // проверяем, а был ли вызван метод save
            verify(usersRepository).save(NOT_EXIST_USER);

            assertNotNull(actual);
        }
    }

}