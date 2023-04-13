/*
Создайте метод, который принимает массив String[] arr и слово String word;
Метод должен возвращать true - если слово есть в массиве, false - если его нету.
Метод не должен менять исходный массив.

Примеры:
- для параметров {"apple", "orange"}, "orange" --> true;
- для параметров {"apple", "orange"}, "banana" --> false;

 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /*
    1) перебираем массив
    2) каждый элемент сравниваем со словом
        - совпало: результат true
        - не совпало - следующий шаг цикла
    3) если так и не нашли - false

    "apple", "red orange","banana" , "orange"
     */
    public static boolean  isWordInArray(String[] array, String word){
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(word)){
                return true;
            }
        }
        return false;
    }

    public static boolean  isWordInArray2(String[] array, String word){
        boolean res=false;
        for (int i = 0; i < array.length && res==false; i++) {
            res=(array[i].equals(word))?true:false;
        }
        return false;
    }

    //{"apple", "orange", "banan"}, "orange"  ->
    public static boolean  isWordInArray3(String[] array, String word){
        int i;
        for (i = 0; i < array.length && !array[i].equals(word); i++);
        return (i<array.length);
    }

    public static boolean  isWordInArray4(String[] array, String word){
        boolean res=false;
        for (int i = 0; i < array.length && !res; res=array[i++].equals(word));
        return res;
    }
}