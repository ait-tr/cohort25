package org.example;

public class Person implements Comparable<Person>{
  private String name;
  private double height;

  public Person(String name, double height) {
    this.name = name;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", height=" + height +
        '}';
  }

  @Override
  public int compareTo(Person o) {
    return Double.compare(this.height, o.height);
  }
}
