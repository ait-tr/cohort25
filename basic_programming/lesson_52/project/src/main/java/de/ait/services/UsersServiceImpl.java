package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.*;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFirstName());
        }

        return names;
    }

    @Override
    public String getLastNameOfMostAging() {

        List<User> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();
        for (User user : users) {
            userAge.put(user.getAge(), user.getLastName());
        }
        int maxAge = Collections.max(userAge.keySet());

        return userAge.get(maxAge);
    }

    @Override
    public void createNewUser(String firstName, String lastName, int age, double height) {
        User newUser = new User(firstName, lastName, age, height);
        usersRepository.save(newUser);
    }


    @Override
    public int getAgeOfTallestPerson() {
        List<User> users = usersRepository.findAll();
        double maxHeight = 0.0;
        int maxAge = 0;

        for (User user : users) {
            if (user.getHeight() > maxHeight) {
                maxHeight = user.getHeight();
                maxAge = user.getAge();
            }
        }

        return maxAge;
    }

    public String getFullNameOfShortest() {
        List<User> users = usersRepository.findAll();
        Map<Double, String> userHeight = new HashMap<>();

        for (User user : users) {
            userHeight.put(user.getHeight(), user.getFullName());
        }

        Double minHeight = Collections.min(userHeight.keySet());

        return userHeight.get(minHeight);


    }

    public double getAverageAge() {
        List<User> users = usersRepository.findAll();
        int totalAge = 0;
        for (User user : users) {
            totalAge += user.getAge();
        }
        if (users.size() > 0) {
            return (double) totalAge / users.size();
        } else {
            return 0.0;
        }
    }

}
