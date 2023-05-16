import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Collection - интерфейс базовый для всех коллекций, для листов, для сетов и т.д.
        // Collections - утилитарный класс, с кучей методов для работы с коллекциями
        // Collections.sort - сортировать любую коллекцию
        // Collections.reverse(); - развернуть лист
        // Collections.copy(); - скопировать один лист в другой
        // Collections.min() Collections.max() - минимальное\максимальное значени


        List<Integer> list = new ArrayList<>(List.of(1,-4,8,12,17,3,8));
        System.out.println(list);
        Collections.sort(list); // сортируем лист
        System.out.println(list);

        List<Auto> autos= new ArrayList<>(List.of(
                new Auto("BMW", 220, 2016),
                new Auto("Audi", 180, 2011),
                new Auto("Mercedes", 230, 2021),
                new Auto("Opel", 120, 2018)
        ));
        System.out.println(autos);
        Collections.sort(autos);
        System.out.println(autos);

        Comparator<Auto> comparator = new ComparatorAutoByYear();
        Collections.sort(autos, comparator );
        System.out.println(autos);

        Auto a1 = new Auto("Audi", 160, 2017);
        Auto a2 = new Auto("Audi", 180, 2011);

        if(a1.compareTo(a2)>1){
            System.out.println("машина a1 больше");
        }
        if (a1.compareTo(a2)<0){
            System.out.println("машина a1 меньше");
        }
        if (a1.compareTo(a2)==0){
            System.out.println("машины равны");
        }

        Comparator<Auto> comparatorByBrand = new ComparatorAutoByBrand();
        Collections.sort(autos, comparatorByBrand );
        System.out.println(autos);

    }
}