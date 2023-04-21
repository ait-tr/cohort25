import java.util.LinkedList;

public class Ship {
    String title;
    Pirate capitan;
    LinkedList<Pirate> crew;
    Ship(String title, Pirate capitan, LinkedList<Pirate> crew){
        this.title = title;
        this.capitan = capitan;
        this.crew = crew;
    }
    public String toString(){
        return title + " Капитан:" + capitan + " Команда:" + crew;
    }
    public void addCrewMember(Pirate pirate){
        crew.add(pirate);
    }
}
