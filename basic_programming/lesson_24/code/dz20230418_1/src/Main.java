/*
### Задание 1
Создайте класс велосипед - Bicycle - с полями:
- brand
- numberOfSpeeds - количество передач
- price - цена

Создайте в main несколько объектов класса велосипед.
После создания: увеличьте стоимость первого велосипеда на 30%

### Задание 2 *
Создайте массив из трех объектов класса велосипед.

 */

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle1=new Bicycle("Lekorn",8, 4000);
        Bicycle bicycle2=new Bicycle("Pokki",1, 57.60);
        Bicycle bicycle3=new Bicycle("Bosch",5, 279.99);

        Bicycle[] bicycles ={bicycle1,bicycle2,bicycle3};
        for (int i = 0; i <bicycles.length ; i++) {
            printBicycle(bicycles[i]);
        }
        System.out.println(" --- поменяли цену ------ ");
        bicycles[0].price = bicycles[0].price*1.3;
        printBicycle(bicycles[0]);
        printBicycle(bicycle1);
    }

    public static void printBicycle(Bicycle bicycle){
        System.out.println(bicycle.brand + " " + bicycle.numberOfSpeeds + " скоростей" + " цена "+ bicycle.price);
    }
}