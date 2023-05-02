/*
Enum
перечисления
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dayOfWeekHandler(DaysOfWeek.FRIDAY); // вызываем метод, передавая день недели
        dayOfWeekHandler(DaysOfWeek.MONDAY);
        dayOfWeekHandler(DaysOfWeek.SUNDAY);

        System.out.println("Печатает весь список");

        DaysOfWeek[] allDaysOfWeek = DaysOfWeek.values(); // получить массив из всех возможных вариантов перечисления
        for (DaysOfWeek day: allDaysOfWeek){
            System.out.println(day.name());
            //System.out.println(day);
        }
        System.out.println(Arrays.toString(allDaysOfWeek)); // печать массива через метод toString класса Arrays

        System.out.println("Ввод дня");
        DaysOfWeek inputedDay = inputDayOfWeek();
        System.out.println(inputedDay);

    }

    public static void dayOfWeekHandler(DaysOfWeek day){
        //System.out.println(day.name());
        System.out.println(day);     // печатает название одного дня
        System.out.println(day.getRuName());

        DaysOfWeek sun = DaysOfWeek.SUNDAY; // пример объявления переменной типа DaysOfWeek

        if(day.equals(sun)){
            System.out.println("Урра! Выходной");
        }
    }

    public  static DaysOfWeek inputDayOfWeek(){
        Scanner scanner= new Scanner(System.in);
        DaysOfWeek[] days= DaysOfWeek.values();
        System.out.println("Введите день недели " + Arrays.toString(days)+ " : ");
        String str =scanner.nextLine();
        str=str.toUpperCase();
        return DaysOfWeek.valueOf(str);
    }




}