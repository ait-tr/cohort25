import java.util.ArrayList;

public class Apartment extends RealProperty{
  private ArrayList<Person> residents;
  private int numberOfRooms;

  public Apartment(String cadastralNumber, double price, Person owner, double area, String adress, ArrayList<Person> residents, int numberOfRooms) {
    super(cadastralNumber, price, owner, area, adress);
    this.residents = residents;
    this.numberOfRooms = numberOfRooms;
  }

  @Override
  public String toString() {
    return "Apartment{" +
        "residents=" + residents +
        ", numberOfRooms=" + numberOfRooms +
        "} " + super.toString();
  }

  public ArrayList<Person> getResidents() {
    return residents;
  }

  public void setResidents(ArrayList<Person> residents) {
    this.residents = residents;
  }

  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }
}
