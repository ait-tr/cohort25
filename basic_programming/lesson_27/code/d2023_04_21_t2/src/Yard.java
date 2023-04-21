import java.util.ArrayList;

public class Yard {
    String adress;
    ArrayList<Chicken> chickens;

    Yard(String adress, ArrayList<Chicken> chickens) {
        this.adress = adress;
        this.chickens = chickens;
    }
    public String toString(){
        return adress + " " + chickens;
    }
    public void feedAll(){
       for(Chicken chicken: chickens){
           chicken.eat(200);
       }
//        for(int i = 0; i < chickens.size(); i++){
//            chickens.get(i).eat(200);
//        }
    }
}
