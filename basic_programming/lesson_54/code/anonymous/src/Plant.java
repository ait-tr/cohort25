public class Plant {
  double height;
  String colorOfFlower;

  public Plant(double height, String colorOfFlower) {
    this.height = height;
    this.colorOfFlower = colorOfFlower;
  }
  public void grow(){
    System.out.println("Растет со скоростью:  "+ height * 0.1);
  }

  @Override
  public String toString() {
    return "Plant{" +
        "height=" + height +
        ", colorOfFlower='" + colorOfFlower + '\'' +
        '}';
  }

  public void blossom(){
    System.out.println("Цвет бутона: " + colorOfFlower);
  }
}
