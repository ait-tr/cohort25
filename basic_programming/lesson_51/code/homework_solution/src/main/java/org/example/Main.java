package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
//    Необходимо создать массив из 1000 людей (каждый человек это имя и рост).
//    Необходимо изменить методы selectionSort и binarySearch таким образом,
//    чтобы они работали с массивом людей (поиск и сортировка по росту)
//    Используйте comparable/comparator

//    // Небольшое вступление
//    Person a = new Person("A-name", 170);
//    Person b = new Person("B-name", 180);
//    System.out.println(a.getHeight() > b.getHeight()); // boolean
//    System.out.println(a.compareTo(b));                // int
//    System.out.println(a.compareTo(b) > 0);            // boolean

    Person[] persons = new Person[1000];
    fillArray(persons);
    System.out.println(Arrays.toString(persons));
    selectionSort(persons);
    System.out.println(Arrays.toString(persons));
    System.out.println(binarySearch(persons, new Person("имя неважно", 1.001)));
  }
  public static void selectionSort(Person[] array) {
    int counter = 0;
    Person currentMin;
    int indexOfCurrentMin;
    Person temp;
    for (int i = 0; i < array.length; i++) {
      currentMin = array[i];
      indexOfCurrentMin = i;

      for (int j = i + 1; j < array.length; j++) { // поиск минимального
        counter++;
        if (array[j].compareTo(currentMin) < 0 ) { // если a[j] меньше, чем текущий минимальный
          currentMin = array[j]; // запоминаем его как минимальный
          indexOfCurrentMin = j; // запомнили его индекс
        }
      }
      temp = array[i];
      array[i] = array[indexOfCurrentMin];
      array[indexOfCurrentMin] = temp;
    }
    System.out.println("В selectionSort было сделано " + counter + " сравнений");
  }

  public static boolean binarySearch(Person[] array, Person element) {
    int counter = 0;
    boolean contains = false;
    int left = 0;
    int right = array.length - 1;
    // вычисляем индекс середины
    int middle = left + (right - left) / 2;
    // мы постоянно повторяем одно и то же действие
    // пока left не перейдет за right
    // это случается, когда числа нет
    while (left <= right) {
      // сравниваем число, которое мы ищем
      // с центральным элементом a[middle]
      counter++;
      if (element.compareTo(array[middle]) < 0) { // если число меньше центра - то двигаем правую границу
        right = middle - 1;
      } else if (element.compareTo(array[middle]) > 0) { // если число больше центра - то двигаем левую границу
        left = middle + 1;
      } else {
        // а если вдруг попали в центр - то значит число нашли
        contains = true;
        break;
      }
      // если мы так и не нашли число, значит у нас изменились границы и
      // следовательно, у нас будет новый центр
      middle = left + (right - left) / 2;
    }
    System.out.println("В binarySearch было сделано " + counter + " сравнений");
    return contains;
  }

  public static void fillArray(Person[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = new Person(getRandomName(),getRandomHeight());
    }
  }
  public static double getRandomHeight(){
    Random random = new Random();
    String heightString = String.format("%.3f", 1 + random.nextDouble(1.2)); // "1,007"
    heightString = heightString.replace(',', '.'); // заменили запятую на точку "1.007"
    return Double.parseDouble(heightString);
    // это можно сделать математически
  }
  public static String getRandomName() {
    Random random = new Random();
    String name = "" + (char) (65 + random.nextInt(26)); // сгенерировали первую букву из заглавныхз
    for (int i = 0; i < 2 + random.nextInt(8); i++) {
      name += (char) (97 + random.nextInt(26));
    }
    return name;
    // можно было первый символ toUpperCase
    // можно заменить на StringBuilder
  }
}