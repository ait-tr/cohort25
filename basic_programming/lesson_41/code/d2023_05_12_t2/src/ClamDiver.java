import java.util.Random;

public class ClamDiver {
  private String name;
  private int pearls;

  public ClamDiver(String name) {
    this.name = name;
    this.pearls = 0;
  }

  public void dive() {
    Random random = new Random();
    int clamsNumber = random.nextInt(11);
    for (int i = 0; i < clamsNumber; i++) {
      Clam clam = new Clam();
      pearls += clam.getNumberOfPearls();
    }
  }

  @Override
  public String toString() {
    return "ClamDiver{" +
        "name='" + name + '\'' +
        ", pearls=" + pearls +
        '}';
  }
}
