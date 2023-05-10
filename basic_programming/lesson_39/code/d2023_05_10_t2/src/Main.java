public class Main {
  public static void main(String[] args) {
    Product product = new Alcohol(
        10,
        "best absinthe in Prague",
        60
    );
    Product product1 = new Tire(
        200,
        "Michelene tire",
        false,
        17
    );
    System.out.println(product.discount());
    System.out.println(product1.discount());
    // Нужно сделать класс Person с полями:
    // - String fullName;
    // - String driverLicence;

    // Пусть у нас будет абстрактный класс School
    // с полями:
    // - String title
    // и абстрактным методом:
    // - void teach(Person person);

    // Создайте класс DrivingSchool
    // - можете сделать поля на ваше усмотрение
    // - сделать реализую для метода teach -
    // пусть этот метод меняет значение в поле driverLicence
    // на "de-871-18-12"
    // ** сделайте чтобы разные цифры присваивались
    DrivingSchool happyWheels = new DrivingSchool("Happy wheels");
    Person bob = new Person("Bob", null);
    Person john = new Person("John", null);
    System.out.println(bob);
    happyWheels.teach(bob);
    System.out.println(bob);
    happyWheels.teach(john, "B");
    System.out.println(john);
  }
}