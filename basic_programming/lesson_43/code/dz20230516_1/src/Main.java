import java.util.List;

/*
## Задание 1

Создайте интерфейс летающее средство (подумайте, как его правильнее назвать), с методами:

 - takeOff() - взлететь, оторваться от земли
 - land() - приземлиться
 - fly(double distance) - лететь

Сделайте классы:
- Balloon - воздушный шар, пусть при взлете он отрывается от земли на 1500 метров.
- Plane - самолет, пусть при взлете он отрывается от земли на 7500 метров.
Пусть у этих классов будет поля:
- высота
- пройденное расстояние в км

## Задание 2 * дополнительно
Ваш код работает, его можно немного перестроить - сделать рефакторинг.
Вынесите повторяющуюся в классах, общую информацию в отдельный абстрактный класс.
 */
public class Main {
    public static void main(String[] args) {
        List<Flyable> flyableList = List.of(
                new Balloon("red", "VinnyPuh"),
                new Balloon("black", "Paddington"),
                new Plane("A316"),
                new Plane("BE8376")
        );

        for (Flyable fl:flyableList){
            fl.takeOff();
            fl.fly(Math.random()*10000);
            //fl.land();
            System.out.println(fl);
        }




    }
}