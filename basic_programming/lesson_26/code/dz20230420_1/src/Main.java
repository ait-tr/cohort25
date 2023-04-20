/*
### Задание 1
Создайте класс Car с полями:
   - brand;
   - horsePowers - сколько лошадиных сил;
   - boolean isElectric; - электрическая ли машина.

Внутри класса создайте конструктор и toString.

Создайте еще один метод drive.
Метод должен выводить в консоль фразу "Zzzzz", - если машина электрическая,
фразу "Brr-brr-brr", если машина не электрическая.

Создайте несколько объектов-машин, вызовите метод drive.

### Задание 2

Создайте ArrayList стрингов.
Добавьте туда произвольное число слов на ваше усмотрение.
Используя цикл, объедините все элементы в одну большую строку String (используйте для этого промежуточную переменную "аккумулятор") и выведите получившийся результат в консоль.
Например, для ["Apple", "Orange", "Grape"] должна получится строка "AppleOrangeGrape".

 */
public class Main {
    public static void main(String[] args) {
        Car bmw= new Car("BMW", 250, true);
        System.out.println(bmw);
        bmw.drive();

        Car audi= new Car("Audi", 180, false);
        System.out.println(audi);
        audi.drive();

        System.out.println("--------------------- Обработка в массиве --------------------------");

        Car[] cars= {bmw,
                     audi,
                    new Car("Opel", 150, false)};

        for (int i = 0; i < cars.length ; i++) {
            cars[i].drive();
        }
        System.out.println("--------------------- Обработка в массиве через for each --------------------------");
        for (Car auto : cars) {
            auto.drive();
        }


    }
}