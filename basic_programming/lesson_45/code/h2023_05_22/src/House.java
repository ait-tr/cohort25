import java.util.ArrayList;

public class House extends RealProperty {
  private ArrayList<Person> residents;
  private int numberOfFloors;

  public House(String cadastralNumber,
               double price, Person owner, double area,
               String adress, ArrayList<Person> residents,
               int numberOfFloors) {
    super(cadastralNumber, price, owner, area, adress);
    this.residents = residents;
    this.numberOfFloors = numberOfFloors;
  }

  @Override
  public String toString() {
    return "House{" +
        "residents=" + residents +
        ", numberOfFloors=" + numberOfFloors +
        "} " + super.toString();
  }

  public ArrayList<Person> getResidents() {
    return residents;
  }

  public void setResidents(ArrayList<Person> residents) {
    this.residents = residents;
  }

  public int getNumberOfFloors() {
    return numberOfFloors;
  }

  public void setNumberOfFloors(int numberOfFloors) {
    this.numberOfFloors = numberOfFloors;
  }
}
