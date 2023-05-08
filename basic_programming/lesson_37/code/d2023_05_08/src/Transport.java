import java.util.ArrayList;
import java.util.List;

public class Transport {
  private String title;
  private int capacity;
  private List<Passenger> passengers = new ArrayList<>();
  private double speed;

  public String getTitle() {
    return title;
  }

  public Transport(){}

  public Transport(String title, int capacity, double speed) {
    this.title = title;
    this.capacity = capacity;
    this.speed = speed;
  }

  public void printPassengers() {
//    for (Passenger passenger : passengers){
//      System.out.println(passenger);
//    }
    System.out.println(passengers);
  }

  public boolean pickPassenger(Passenger passenger) {
    if (passengers.size() < capacity) {
      return passengers.add(passenger);
    }
    return false;
  }

  public void dropPassenger(String passengerName) {
//    passengers.removeIf(passenger -> passengerName.equals(passenger.getName()));
    for (int i = passengers.size() - 1; i >= 0; i--) {
      if (passengers.get(i).getName().equals(passengerName)) {
        passengers.remove(i);
      }
    }
    // a b d
  }

  public Passenger dropPassengerVer2(String passengerName) {
//    passengers.removeIf(passenger -> passengerName.equals(passenger.getName()));
    for (int i = passengers.size() - 1; i >= 0; i--) {
      if (passengers.get(i).getName().equals(passengerName)) {
        return passengers.remove(i);
      }
    }
    return null;
    // a b d
  }


}
