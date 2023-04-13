/*
Создайте метод, который принимает массив слов, и заменяет самое длинное слово на "***".

Например,для массива {"apple", "orange", "grape"} вызов метода изменит массив на  {"apple", "***", "grape"}.
Данный метод должен менять исходный массив.

1) переменная под ИНДЕКС самого длинного слова = 0
2) перебираем массив
3) каждый элемент сравниваем с текущим самым длинным словом
    если в массиве слово длиннее ->  в переменную "ИНДЕКС самого длинного слова"
    запиываем текущее i


 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {"Jack", "John", "Andrey", "Anna"};
        System.out.println("Исходный массив:");
        print(strings);
        changeWord(strings, getIndexOfMaxWord(strings));
        System.out.println("массив результат:");
        print(strings);
    }

    public static void print(String[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
    public static int getIndexOfMaxWord(String[] array){
        int maxIndex=0;
        for (int i = 1; i < array.length ; i++) {
            if(array[i].length() > array[maxIndex].length()) {
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public static void changeWord(String[] array, int index){
        array[index]="****";
    }


    public static int getIndexOfMaxWord2(String[] array){
        int maxIndex=0;
        String maxWord=array[0];
        for (int i = 1; i < array.length ; i++) {
            if(array[i].length() > maxWord.length()) {
                maxIndex=i;
                maxWord=array[i];
            }
        }
        return maxIndex;
    }



}

