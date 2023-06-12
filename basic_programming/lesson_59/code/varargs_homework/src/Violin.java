import java.time.LocalDate;

public class Violin implements Comparable<Violin>{
  private String nameOfMaster;
  private LocalDate dateOfManufacturing;

  public Violin(String nameOfMaster, LocalDate dateOfManufacturing) {
    this.nameOfMaster = nameOfMaster;
    this.dateOfManufacturing = dateOfManufacturing;
  }

  public String getNameOfMaster() {
    return nameOfMaster;
  }

  public LocalDate getDateOfManufacturing() {
    return dateOfManufacturing;
  }

  @Override
  public String toString() {
    return "Violin{" +
        "nameOfMaster='" + nameOfMaster + '\'' +
        ", dateOfManufacturing=" + dateOfManufacturing +
        '}';
  }

  @Override
  public int compareTo(Violin o) {
    if(dateOfManufacturing.equals(o.dateOfManufacturing)){
      return nameOfMaster.compareTo(o.nameOfMaster);
    }
    return dateOfManufacturing.compareTo(o.dateOfManufacturing);
  }
}
