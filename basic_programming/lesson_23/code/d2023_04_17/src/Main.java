public class Main {
    public static void main(String[] args) {
        // будем объекты класса Dog
        // объект или экземпляр - это конкретный представитель класса
        // у полей будут конкретные значения для каждого объекта
        Dog rex = new Dog(3, "Rex");
        System.out.println(rex.age);
        System.out.println(rex.name);
        // по аналогии
        // создайте объект класс Dog touzik
        // с именем "Touzik" и возрастом 12
        // распечатайте имя тузика и его возраст
        Dog touzik = new Dog(12, "Touzik");
        System.out.println(touzik.age);
        System.out.println(touzik.name);
        // Создайте класс Book
        // со следующими полями:
        // - title  - это название книги
        // - author - это автор книги
        // - year   - год выпуска
        // После этого сделайте несколько объектов в main
        Book harryPotter =
                new Book("Harry Potter and Philosopher Stone",
                        "J.R.Rouling", 1997);
        Book book1984 = new Book("1984", "J. Oruell", 1949);
        System.out.println(book1984.title);
        System.out.println(harryPotter.author);
        book1984.author = "Lev Tolstoy";
        System.out.println(book1984.author);
        /*
         Создайте класс Ресторан
         Restaurant со следующими полями:
          - title        - название ;
          - chairsNumber - количество посадочных мест;
          - cousin       - тип кухни;
         Создайте объект класса Restaurant
         и после создания
         измените значение кухни на "european"
         */
        Restaurant kabuki = new Restaurant(
                "Kabuki", 50, "japanese");
        System.out.println(kabuki.cousine);
        kabuki.cousine = "european";
        // Создайте класс
        // Museum со следующими полями:
        // - title
        // - ticketPrice - цена билета
        // - city - город, где музей находится
        // Создайте два объекта этого класса - два конкретных музея
        // После того как вы создали музеи
        // измените цену билета в обоих музеях
        Museum luvr = new Museum("Luvr", 20, "Paris");
        // изменили цену билета на новое значение
        luvr.ticketPrice = 21;
        System.out.println(luvr.ticketPrice);
        luvr.ticketPrice = luvr.ticketPrice * 1.2; // luvr.ticketPrice *= 1.2;

    }
}