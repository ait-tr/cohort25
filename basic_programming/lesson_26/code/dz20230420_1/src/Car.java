public class Car {

    String brand;
    int horsePowers;
    boolean isElectric;

    Car(String brand, int horsePowers, boolean isElectric){
        this.brand=brand;
        this.horsePowers = horsePowers;
        this.isElectric = isElectric;
    }

    public String toString(){
        //return brand + " "+ horsePowers+"л.с. " + isElectric;
        return brand + " "+ horsePowers+"л.с. " + (isElectric?"electro":"benzin");
    }

    public void drive(){
        System.out.println(brand + ": " + (isElectric?"Zzzzz":"Brr-brr-brr"));
    }




}
