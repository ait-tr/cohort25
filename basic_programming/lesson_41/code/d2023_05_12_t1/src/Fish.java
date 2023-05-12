public class Fish {
  private String type;
  private int length;
  private double weight;

  public Fish(String type) {
    this.type = type;
    this.length = 7 + (int)(Math.random() * (60 - 7 +1));
    this.weight = length * 40;
  }

  @Override
  public String toString() {
    return "Fish{" +
        "type='" + type + '\'' +
        ", length=" + length +
        ", weight=" + weight +
        '}';
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getType() {
    return type;
  }

  public int getLength() {
    return length;
  }

  public double getWeight() {
    return weight;
  }
}
