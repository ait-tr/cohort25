package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UsersRepositoryFileImpl is works ...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class UsersRepositoryFileImplTest {

        // сделали константу, которая хранит название временного файла
        private static final String TEMP_USERS_FILE_NAME = "users_test.txt";

        private UsersRepositoryFileImpl usersRepository; // объект, который мы тестируем

        //нужно, чтобы перед каждым тестом у вас создавался временный файл
        @BeforeEach
        public void setUp() throws Exception {

                createNewFileForTest(TEMP_USERS_FILE_NAME); // создали файл на диске

                usersRepository = new UsersRepositoryFileImpl(TEMP_USERS_FILE_NAME); // создали объект для тестирования
        }

        // нужно удалять временный файл после каждого теста
        @AfterEach
        public void tearDown() throws Exception {
                deleteFileAfterTest(TEMP_USERS_FILE_NAME);
        }

        @DisplayName("save():")
        @Nested
        class Save {

                @Test
                public void writes_correct_line_to_file() throws Exception {
                        User user = new User("user@ait-tr.de", "qwerty008"); // создаем пользователя

                        usersRepository.save(user); // вызываем метод, который мы тестируем

                        String expected = "1#user@ait-tr.de#qwerty008"; // строка, которую мы ожидаем

                        BufferedReader reader = new BufferedReader(new FileReader(TEMP_USERS_FILE_NAME)); // открыли файл для чтения

                        String actual = reader.readLine(); // считали строку из файла, после вызова метода save

                        reader.close(); // закрыли файл после чтения

                        assertEquals(expected, actual); // сравнили то, что ожидаем, с тем, что реально записалось в файл
                }
        }

        @DisplayName("findAll():")
        @Nested
        class FindAll {

                @Test
                public void returns_correct_list_of_users() throws Exception {
                        // запишем в файл напрямую список каких-либо людей
                        BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_USERS_FILE_NAME)); // открыли файл для записи

                        // записали строки для тестирования метода
                        writer.write("1#user@ait-tr.de#qwerty008");
                        writer.newLine();
                        writer.write("2#user2@ait-tr.de#qwerty009");
                        writer.newLine();
                        writer.close(); // закрыли файл после записи

                        // формируем ожидаемый список пользователей
                        List<User> expected = Arrays.asList(
                                new User(1L, "user@ait-tr.de", "qwerty008"),
                                new User(2L, "user2@ait-tr.de", "qwerty009")
                        );

                        List<User> actual = usersRepository.findAll(); // получаем фактический список пользователей

                        assertEquals(expected, actual);
                }
        }

        private static void createNewFileForTest(String fileName) throws IOException {

                File file = new File(fileName);

                deleteIfExists(file);

                // файла точно нет, теперь можно создавать
                boolean result = file.createNewFile();

                if (!result) { // если по каким-либо причинам его не получилось создать
                        throw new IllegalStateException("Problems with file create");
                }
        }

        private static void deleteFileAfterTest(String fileName) {
                File file = new File(fileName);

                deleteIfExists(file);
        }

        private static void deleteIfExists(File file) {
                // проверим, а вдруг файл уже есть?
                if (file.exists()) {
                        // Тогда нужно его удалить
                        boolean result = file.delete();

                        if (!result) { // если по каким-либо причинам его не получилось удалить
                                throw new IllegalStateException("Problems with file delete");
                        }
                }
        }
}