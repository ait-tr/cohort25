import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Допустим у нас ArrayList неуникальных значений
        ArrayList<String> words =
                new ArrayList<>(List.of("apple",
                        "orange", "apple", "banana"));
        // Как можем создать множество HashSet на основании листа
        // обратите внимание, что повторяющиеся значения исчезли
        HashSet<String> uniqueWords = new HashSet<>(words);
        System.out.println(uniqueWords);
        // Можем ли создать ArrayList на основании множества
        ArrayList<String> uniqueList = new ArrayList<>(uniqueWords);
        System.out.println(uniqueList);

        // Представим коллекционера монет.
        // Напишите в мейне метод, который принимает ArrayList<String>
        // возвращает число уникальных монет
        // ["рубль 1992", "юань 1957", "рубль 1992"] --> 2
        // coins
        // *
        // Создайте еще один метод, который бы возвращал ArrayList<String>
        // уникальных значений
        ArrayList<String> coins =
                new ArrayList<>(List.of("рубль 1992", "юань 1957", "рубль 1992"));
        System.out.println(getNumberOfUnique(coins));
        System.out.println(getUniqueCoins(coins));
    }

    public static int getNumberOfUnique(ArrayList<String> coins) {
        HashSet<String> coinsSet = new HashSet<>(coins);
        return coinsSet.size();
    }

    public static ArrayList<String> getUniqueCoins(ArrayList<String> coins) {
        HashSet<String> coinsSet = new HashSet<>(coins);
        ArrayList<String> uniqueCoins = new ArrayList<>(coinsSet);
        return uniqueCoins;
        // return new ArrayList<>(coinsSet); // более короткий вариант
    }
    // Code Wars
}