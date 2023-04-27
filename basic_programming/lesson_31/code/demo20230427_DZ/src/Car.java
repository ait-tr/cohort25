public class Car {
    String numberPlate;
    int gas;
    String brand;
    String owner;
    String telephone;


    Car(String numberPlate, int gas, String brand, String owner, String telephone){
        this.numberPlate=numberPlate;
        this.brand=brand;
        this.gas=gas;
        this.owner= owner;
        this.telephone=telephone;
    }

    @Override
    public String toString() {
        return String.format("Машина %s №%s (бензин %d). Владелец: %s %s  ",brand,numberPlate,gas,owner,telephone);
    }
}
