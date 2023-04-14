public class D2023_04_13_t1 {
    public static void main(String[] args) {
//        Создайте метод, который принимает массив слов, и заменяет все самые длинные слова на "***".
//
//                Например,для массива {"John","Ann", "Jack", "Ray"} вызов метода изменит
//        массив на {"***","Ann", "***", "Ray"}.
//        Данный метод должен менять исходный массив
        String[] words1 = new String[]{"John","Ann", "Jack", "Ray"};
        String[] words2 = new String[]{"Johny","Ann", "Jack", "Ray Charles"};
        replaceLongest(words1);
        replaceLongest(words2);
        print(words1);
        print(words2);
    }
    public static void print(String[] arr){
        for (int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void replaceLongest(String[] words) {
        // - найти maxLength
        int maxLength = words[0].length();
        for(int i = 1; i < words.length; i++){
            if(words[i].length() > maxLength){
                maxLength = words[i].length();
            }
        }
        // после того как мы прошли по всему массиву
        // только теперь maxLength - длинна самого большого слова
        // - заменить все слова с этой длинной на звездочки
        for (int i = 0; i < words.length; i++){
            if (words[i].length() == maxLength){
                words[i] = "***";
            }
        }
    }
}
