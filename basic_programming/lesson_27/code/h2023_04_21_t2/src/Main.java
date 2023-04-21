import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      /*
      Напишите метод, который получает `List<String>’,
      а возвращает LinkedList<String>, который содержит
      все строки исходного List’а но в обратном порядке
      Например:
      {"1. Джэк","2. Джон","3. Ник"} -->
      {"3. Ник","2. Джон", “1. Джэк”}
        */
        List<String> words = new LinkedList<>();
        words.add("Джэк");
        words.add("Джон");
        words.add("Ник");
        LinkedList<String> reversedList = getReversed(words);
        System.out.println(reversedList);
        System.out.println(getReversed(words));
    }
    public static LinkedList<String> getReversed(List<String> words){
        LinkedList<String> newList = new LinkedList<>();
        for(String word: words){
            newList.addFirst(word); // newList.add(0, word);
        }
        return newList;
    }
}