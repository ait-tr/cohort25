package de.ait.repositories;

import de.ait.models.User;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName); 
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                User user = parseLine(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return users;
    }

    private static User parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        double height = Double.parseDouble(parsed[3]);

        return new User(
                firstName, lastName, age, height
        );
    }

    @Override
    public void save(User user) {
        try (
                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {;
            bufferedWriter.write(user.getFirstName() + "|" + user.getLastName() + "|" + user.getAge() + "|" + user.getHeight());
            bufferedWriter.newLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
