public class Ship extends Transport {
  private String captainsName;

  public Ship(String title, int capacity,
              double speed, String captainsName) {
    super(title, capacity, speed);
    this.captainsName = captainsName;
  }
  public void captainGreeting(){
    System.out.println(
        "Капитан " + captainsName
            +" приветствует вас на борту " + getTitle());
  }


}
