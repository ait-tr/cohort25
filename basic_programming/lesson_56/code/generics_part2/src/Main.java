public class Main {
  public static void main(String[] args) {
    // панда внутри клетки
    PandaCage pandaCage = new PandaCage(new Panda());
    // можем вызвать метод класс Panda
    pandaCage.prisoner.eatBamboo();
    // сможем ли мы в PandaCage положить тигра?
    TigerCage tigerCage = new TigerCage(new Tiger());
    // можем вызвать метод от заключенного - это метод класса Tiger
    tigerCage.prisoner.roar();

    // Как бы это выглядело без дженериков
    ObjectCage objectCage1 = new ObjectCage(new Panda());
    ObjectCage objectCage2 = new ObjectCage(new Tiger());
    // нет никакого ограничения, что можем пеместить внутрь
    ObjectCage objectCage3 = new ObjectCage(tigerCage);
    // Какая проблема?
    // 1. во-первых нет ограничений, что мы можем туда положить
    // 2. мы не можем вызвать методов специфических для конкретных классов
    // например, не можем вызвать метод eat bamboo
    // objectCage2.prisoner.eatBamboo();  // - eatBamboo() - горит красным
    // - потому что у класса объект нет такого метода

    // Поэтому нам и нужны дженерики
    // Мы сможем сделать универсальный класс, и методы будут нам доступны
    Cage<Panda> cage1 = new Cage<>(new Panda());
    // в отличие от ObjectCage - нам доступны методы
    cage1.prisoner.eatBamboo();
    // Не можем создать клетку с человеком -
    // потому что у нас ограничения public class Cage <T extends Animal>
    // Cage<Person> cage2 = new Cage<Person>(new Person()); // с ошибкой

    // Задание 1 - на закрепление новой темы
    // Создайте класс Food - еда
    // Создайте производные классы:
    //  - Dessert
    //  - Pasta
    // Вам нужно создать обобщенный класс:
    // - Tupperware
    //  c полем containing - содержимое - обобщенное поле - только еда и наследники
    //    ниже задание со *
    //  c методами:
    //    - throwAway() - очищает контейнер
    //    - getFood()   - очищает контейнер и возвращает содержимое
    //    - addFood     - добавляет указанную еду в контейнер
    Tupperware<Pasta> container1 = new Tupperware<>();
    System.out.println(container1);
    container1.addFood(new Pasta("Balanyeza", 10));
    System.out.println(container1);
    // достали из контейнера
    Pasta dinner = container1.getFood();
    System.out.println(dinner);
    // контейнер вновь пуст - положим туда новую пасту
    container1.addFood(new Pasta("Carbanara", 13));
    // попробуем добавить в контейнер, где уже есть паста
    // false - не получилось добавить
    boolean result = container1.addFood(new Pasta("Marina", 13));
    System.out.println(result); // false
    System.out.println(container1);
    // Допустим, забыли съесть и она испортилась.
    // Выбросим ее.
    container1.throwAway();
    System.out.println(container1);
  }
}