import java.util.LinkedList;
// Создайте класс пират Pirate с полями:
// - имя
// - возраст
// - количество ног
// Добавьте методы toString и конструктор

// Создать класс корабль Ship с полями:
// - String title;
// - Pirate captain; - капитан тип Pirate
// - LinkedList<Pirate> crew; - команда
// Добавьте методы: конструктор, toString
// и еще один метод:
// public void addCrewMember(Pirate pirate)
// -- метод добавляет в команду crew указанного пирата

// создать несколько пиратов - объектов
// LinkedList<Pirate> initialCrew = new LinkedList<>();
// создать корабль - и добавить пиратов в команду
// new Ship("Black Widow", captain1, initialCrew);
public class Main {
    public static void main(String[] args) {
        Pirate davieJohns =
                new Pirate("Davie Johns", 40,2);
        Pirate john = new Pirate("John", 22, 2);
        Pirate bob = new Pirate("Bob", 23, 1);
        Ship flyingHolland =
                new Ship("Flying Holland", davieJohns, new LinkedList<Pirate>());
        System.out.println(flyingHolland);
        flyingHolland.addCrewMember(new Pirate("Max", 19, 2));
        flyingHolland.addCrewMember(new Pirate("Dilan", 29, 2));
        flyingHolland.addCrewMember(john);
        flyingHolland.addCrewMember(bob);
        System.out.println(flyingHolland);
    }
}