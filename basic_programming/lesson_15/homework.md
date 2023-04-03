### Задание 1
Напишите метод, который возвращает сумму чисел от - 100 до -200. Метод не принимает никаких параметров. И ничего не выводит в печать. 

### Задание 2
Создайте метод multiplyString, который принимает:
- String word - слово;
- int n - количество повторений.   

Метод возвращает тип String, слово повторенное n раз.  
Пример вызова метода:
- multiplyString("apple", 3); --> "appleappleapple"
- multiplyString("cat_", 7); --> "cat_cat_cat_cat_cat_cat_cat_"  
P.S. Используйте цикл, а не метод repeat
```` Java
public static String multiplyString(String word, int n){
String accumulator = ""; // создали переменную аккумулятор 
// к ней будем присоединять строки
// здесь ваш цикл // обновляете в нем значение переменной accumulator
// здесь ваш код

    return accumulator; // вернули, все что приплюсовали
}
````

