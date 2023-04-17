public class H2023_04_17_t1 {
    public static void main(String[] args) {
        // Создайте метод, который принимает массив
        // слов и char symbol, и заменяет все слова
        // оканчивающиеся на этот символ на слово bingo.
//        String word = "apple";
//        word.charAt(word.length()-1);
        String[] fruits = {"apple", "orange", "banana"};
        String[] cars = {"bmw", "porsche", "opel"};
        String[] arr = {"word1", "word2"};
        replaceWordsWithBingo(fruits, 'e');
        replaceWordsWithBingo(cars, 'e');
        print(fruits);
        print(cars);
    }
    public static void print(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void replaceWordsWithBingo(String[] arr, char symbol){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].charAt(arr[i].length()-1) == symbol){
                arr[i] = "bingo";
            }
        }
    }
}
