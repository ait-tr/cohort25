public class Car {
    private String brand;
    private  int year;
    private static int discount=0;

    private static int totalNumberOfCars=0;
    private static double price=1000;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
        totalNumberOfCars++;
    }

    public static int getTotalNumberOfCars(){
        return totalNumberOfCars;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + getPrice() +
                '}';
    }
    public static void setPrice(double price){
        Car.price=price;   // вместо this для статических полей класса используем имя класса
    }
    public static  void setDiscount(int discount){
        Car.discount=discount;
    }

    public static  double getPrice(){
        return price-(price * (discount*0.01));
    }
}
