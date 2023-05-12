import java.util.Random;

public class Clam {
  private int numberOfPearls;

  public int getNumberOfPearls() {
    return numberOfPearls;
  }

  public Clam() {
    Random random = new Random();
    this.numberOfPearls = random.nextInt(5);
  }

  @Override
  public String toString() {
    return "Clam{" +
        "numberOfPearls=" + numberOfPearls +
        '}';
  }
}
