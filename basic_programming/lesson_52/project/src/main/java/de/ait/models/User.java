package de.ait.models;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public User(String firstName, String lastName, int age, double height) {
        // TODO: сделать проверки входных данных
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age +
                " " + height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getAge() == user.getAge() && Double.compare(user.getHeight(), getHeight()) == 0 && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getHeight());
    }
}
