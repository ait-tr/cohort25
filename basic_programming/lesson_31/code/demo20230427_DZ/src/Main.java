import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
Представим, что мы создаем программу для автосервиса.
1. Создайте класс Car с полями:
   - String numberPlate; - это автомобильный номер например "d812ce"
   - int gas;  - это бензин, например: 98
   - brand; - это марка машины
   - String owner; - имя владельца
   - String telephone; - номер телефона владельца

2.  Создайте в main словарь` HashMap<String, Car> `
     - Тип ключа string - это номер знака "d812ce".
     - Тип значения - это Car.
3. Заполните словарь парами ключ-значение
4. Создайте в классе nested.example01.Main метод `public static void printCarInfo(HashMap<String, Car> carsMap)`
   - Метод должен спрашивать у клиента номер автомобиля
   - Метод должен выводить в консоль информации про этот автомобиль в следующем виде:
`Машина марки <brand> с собственником <owner> с телефоном <telephone>, бензин: <gas>`
5. Вызовите метод



 */
public class Main {
    public static void main(String[] args) {
        List<Car> carList = readListCars();
        System.out.println(carList);
        System.out.println("-------------------------------------");
        HashMap<String,Car> carsMap = createNumberToCarMap(carList);
        printCarInfo(carsMap);
    }

    public static HashMap<String,Car> createNumberToCarMap (List<Car> list){
        HashMap<String,Car> numberToCar = new HashMap<>();
        for (Car car: list){
            numberToCar.put(car.numberPlate,car);
        }
        return numberToCar;
    }

    public  static  List<Car> readListCars(){
        return List.of(
                new Car("d812ce",98,"Audi","Jack", "11-11-11"),
                new Car("b865ka",95,"Opel","John", "22-22-22"),
                new Car("d765va",98,"Audi","Anna", "22-33-33"),
                new Car("v987ce",95,"Volvo","Nick", "14-15-61"),
                new Car("k896ce",98,"Lada","Svan", "11-15-98")
        );
    }
    
    public static void printCarInfo(HashMap<String, Car> carsMap){
        System.out.println("Input the number of the car:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        Car car = carsMap.get(number);
        if(car!=null){
            /// печатать инфо об авто
            System.out.printf("Машина марки <%s> с собственником <%s> с телефоном <%s>, бензин: <%d>%n",
                    car.brand,
                    car.owner,
                    car.telephone,
                    car.gas
                    );
        } else {
            System.out.println("нет авто с номером " + number);
        }
    }
}