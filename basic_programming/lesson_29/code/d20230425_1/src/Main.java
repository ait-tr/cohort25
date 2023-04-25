/*
Написать программу, которая:

прочитает с клавиатуры(получит от пользователя) количество чисел
прочитает с клавиатуры сами числа и соберёт их в множество
удалит из множества числа, которые больше чем 10
выведет полученные результаты на экран
Все числа, которые подаются на вход, целые.
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = createSetFromConsole();
        System.out.println(set);
        set= removeNumbersMoreThan10v2(set);
        System.out.println(set);



    }

    public static HashSet<Integer> createSetFromConsole(){
        HashSet<Integer> set = new HashSet<>();
        // количество элементов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов: ");
        int size= scanner.nextInt();
        //////

        for (int i = 1; i <= size; i++) {
            System.out.println("Введите " + i +" элемент: ");
            set.add(scanner.nextInt());
        }
        return set;
    }

    public static HashSet<Integer> removeNumbersMoreThan10(HashSet<Integer> set){ // здесь remove - название моего метода
        /* !!! ConcurrentModificationException
        for(Integer i:set){
            if(i>10){
                set.remove(i); // здесь remove - метод HashSet
            }
        }

         */
        HashSet<Integer> temp = new HashSet<>(); // числа, которые будем удалять
        for(Integer i:set){
            if(i>10){
                temp.add(i);
            }
        }
        set.removeAll(temp);
        return set;

    }


    public static HashSet<Integer> removeNumbersMoreThan10v2(HashSet<Integer> set){ // здесь remove - название моего метода
        HashSet<Integer> temp = new HashSet<>(); // числа, которые должны остаться в результате
        for(Integer i:set){
            if(i<=10){
                temp.add(i);
            }
        }
        return temp;

    }



}
