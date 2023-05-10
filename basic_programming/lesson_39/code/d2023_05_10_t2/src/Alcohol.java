public class Alcohol extends Product{
  // Создайте производный класс Alcohol c полями:
  // double strength;
  // реализуйте метод discount - возвращает цену со скидкой:
  // если крепость алкоголя >= 30, то скидка 5 %
  // если крепость алкоголя <30, то скидка 10%
  private double strength;

  public Alcohol(double price, String description, double strength) {
    super(price, description);
    this.strength = strength;
  }

  @Override
  public double discount(){
    if(strength>= 30){
      return getPrice() * 0.95;
    }
    return getPrice() * 0.9;
  }
}
