package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
 private UsersServiceImpl usersService; /// ob
    private UsersRepositoryListImpl usersRepositoryList;
    @BeforeEach
    void setUp() {
        this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());
        this.usersRepositoryList = new UsersRepositoryListImpl();
    }

    @Test
    void getNames() {
        List<String> actual = usersService.getNames();
        List<String> expected = Arrays.asList("Marsel", "Maxim", "Ruslan","Kirill", "Anna");
        assertEquals(expected, actual);
    }

    @Test
    void Test1_CreateNewUser(){
        User actual = usersService.createNewUser(usersRepositoryList.getUsers().get(0).getFirstName(),
                usersRepositoryList.getUsers().get(0).getLastName(),
                usersRepositoryList.getUsers().get(0).getAge(),
                usersRepositoryList.getUsers().get(0).getHeight());
        User expected = new User("Marsel", "Sidikov", 29, 1.85);
        assertEquals(expected,actual);
    }
    @Test
    void Test2_CreateNewUser(){
        User actual = usersService.createNewUser(usersRepositoryList.getUsers().get(1).getFirstName(),
                usersRepositoryList.getUsers().get(1).getLastName(),
                usersRepositoryList.getUsers().get(1).getAge(),
                usersRepositoryList.getUsers().get(1).getHeight());
        User expected = new User("Maxim", "Ivanov", 19, 1.79);
        assertEquals(expected,actual);
    }
    @Test
    void testGetLastNameOfMostAging(){
        String actual = usersService.getLastNameOfMostAging();
        String expected = "Petrov";
        assertEquals(expected,actual);
    }
    @Test
    void getAverageAge() {
        double actual = usersService.getAverageAge();
        double expected = 39.6;
        assertEquals(expected,actual);
    }

    @Test
    void getAgeOfTallestPerson() {
        int actual = usersService.getAgeOfTallestPerson();
        int expected = 55;
        assertEquals(expected,actual);
    }
    @Test
    void testGetFullNameOfShortest() {
        String actual= usersService.getFullNameOfShortest();
        String expected = "Anna Petrova";

        assertEquals(expected, actual);
    }
}