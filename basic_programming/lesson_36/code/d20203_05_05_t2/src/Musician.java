public class Musician extends Person{
  String instrument;
  public Musician(String name, int age, String instrument){
    super(name, age);
    this.instrument = instrument;
  }
  public String toString(){
    // super.getName() можно сократить просто до getName()
    return "Музыкант: " + getName()
        + " Возраст: " + getAge()
        + " Инструмент: " + instrument;
  }
}
