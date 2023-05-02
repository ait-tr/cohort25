/*
Enum
перечисления
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       dayOfWeekHandler(DaysOfWeek.FRIDAY); // вызываем метод, передавая день недели
        dayOfWeekHandler(DaysOfWeek.MONDAY);

       System.out.println("Печатает весь список");

      DaysOfWeek[] allDaysOfWeek = DaysOfWeek.values(); // получить массив из всех возможных вариантов перечисления
      for (DaysOfWeek day: allDaysOfWeek){
          System.out.println(day.name());
      }
        System.out.println(Arrays.toString(allDaysOfWeek)); // печать массива через метод toString класса Arrays
    }

    public static void dayOfWeekHandler(DaysOfWeek day){
        //System.out.println(day.name());
        System.out.println(day);     // печатает название одного дня

    }

}