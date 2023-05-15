public class Orange {
  int diameter;
  Orange(){
    int min = 7;
    int max = 15;
    diameter = min + (int)(Math.random()*(max - min + 1));
  }

  @Override
  public String toString() {
    return "Orange{" +
        "diameter=" + diameter +
        '}';
  }

}
