import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Land land1 = new Land(
        "de123123123",
        50_000,
        new Person("Robert", "Ratfeller"),
        4000,
        "Landstr 27",
        LandPurpose.INDUSTRIAL
    );
    System.out.println(land1);
    Forest sosnavka = new Forest(
        "de1230039393",
        1_000_000,
        new Person("Bob", "Forester"),
        50_000,
        "Lesnaya 19",
        false
    );
    House burgeStr27 = new House(
        "de1309393",
        20_000_000,
        new Person("Robert", "Ratfeller"),
        2_500,
        "Berlin, Burge str.9",
        new ArrayList<Person>(List.of(
            new Person("Ivanov", "Ivan"),
            new Person("John", "Smith")
        )),
        4
    );
    Apartment kv27 = new Apartment(
        "de12312",
        2_000_000,
        new Person("Semen", "Semenov"),
        120,
        "Berlin, Landberger str. 150",
        new ArrayList<Person>(
            List.of(new Person("Semen", "Semenov"))),
        2
    );
    ArrayList<RealProperty> propertyArrayList = new ArrayList<>();
    propertyArrayList.add(land1);
    propertyArrayList.add(kv27);
    propertyArrayList.add(burgeStr27);
    propertyArrayList.add(sosnavka);
    sortByAdress(propertyArrayList);
    System.out.println(propertyArrayList);
  }
  public static void sortByAdress(ArrayList<RealProperty> arr){
    arr.sort(new PropertyByAdressComparator());
  }
}