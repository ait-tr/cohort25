import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      /*
      Напишите метод, который получает массив из строк,
      а возвращает LinkedList<String>, который содержит
      все строки исходного массива начинающиеся на “при”.
      Например:
        {“пришел”,“поехал”,“приехал”,“проехал”} --> {“пришел”,“приехал”}
        Желательно использовать for…each
        */
        String[] arr = {"пришел","поехал","приехал","проехал"};
        LinkedList<String> filteredList = filterPri(arr);
        System.out.println(filteredList);
    }
    public static LinkedList<String> filterPri(String[] words){
        LinkedList<String> newWords = new LinkedList<>();
        // вариант с обычным for
//        for(int i = 0; i < words.length; i++){
//            if(words[i].startsWith("при")){ //words[i].substring(0,3).equals("при")
//                newWords.add(words[i]);
//            }
//        }
        // вариант 2 с циклом for-each
        for(String word: words){
            if(word.startsWith("при")){
                newWords.add(word);
            }
        }
        return newWords;
    }
}