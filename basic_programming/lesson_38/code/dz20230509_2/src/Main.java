/*
Создайте класс автомобиль с полями:
- бренд,
- год.

И статическими полями:
- всего выпущено машин - totalNumberOfCars;
- цена;

Сделайте так, чтобы автоматически осуществлялся подсчет созданных машин(объектов).
(подсказка: это нужно сделать в конструкторе)
Создайте несколько машин, выведите totalNumberOfCars в печать.

Дополнительно * , придумайте методы, которые бы каким-нибудь образом взаимодействовали бы с ценой.

 */
public class Main {
    public static void main(String[] args) {
        Car car1= new Car("Audi", 2005);
        Car car2= new Car("BMW", 2007);
        Car car3= new Car("Opel", 2010);
        Car car4= new Car("Lada", 2015);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println("Всего машин: " + Car.getTotalNumberOfCars());

        Car.setPrice(10000);
        System.out.println("------------ set new price for all ------------------");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println("Актуальная цена: "+ Car.getPrice() );


        System.out.println("------------ set discont ------------------");
        Car.setDiscount(10);
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println("Актуальная цена: "+ Car.getPrice() );

    }
}