public class Main {
    public static void main(String[] args) {
        // Примитивные типы
        int x = 30;
        int y = x;
        x = 60;
        System.out.println(y);
        // Ссылочный тип, на примере массива
        int[] arr = new int[]{10, 11, 12};
        int[] arr2 = arr;
        arr2[0] = 999; // изменил второй массив
        print(arr);    // как мы видим, оба изменились
        print(arr2);
        // Мутирующие и не мутирующие методы
        // print - не меняет значений массива - поэтому не мутирует массив
        // метод  changeAllToTen мутировал массив - то есть изменил его значения
        changeAllToTen(arr2);
        print(arr2);
        mutate(arr2);
        print(arr2);
        //
        // Создайте метод,
        // который возвращает длину самого большого слова из массива
        //
        // если передать в качестве аргумента массив
        // {"apple", "pear"}
        // метод вернет --> 5
        //
        // ** со звездочкой
        // пусть метод возвращает массив
        // {самаяМаленькаяДлина, самаБольшаяДлинна}
        // {"apple", "pear", "grape"} --> {4, 5}
        String[] fruits = new String[]{"apple", "pear", "grape"};
        int result = getMaxLength(fruits);
        System.out.println(result);

        // Создайте мутирующий метод, который
        // заменяет все слова длиннее 4 (строго больше) символов на "***"
        // метод принимает массив String
        // возвращает void
        // {"apple", "pear", "grape"} --> void
        // {"***", "pear", "***"}
        String[] fruits2 = new String[]{"apple", "pear", "grape", "lime"};
        replaceLongWordsWithStar(fruits2);
        printStringArr(fruits2);
    }
    public static void replaceLongWordsWithStar(String[] arr){
        for(int i =0; i< arr.length; i++){
            if(arr[i].length() > 4){
              arr[i] = "***";
            }
        }
    }

    public static void printStringArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int getMaxLength(String[] array) {
        // записали длину первого слова в отдельную переменную
        int maxLength = array[0].length(); // maxLength == самая большая длина из встреченных
        for (int i = 1; i < array.length; i++) {
            if (array[i].length() > maxLength) {
                maxLength = array[i].length();
            }
        }
        return maxLength;
    }

    public static String mutate(int[] arr) {
        arr[0] = 9999999;
        return "Я мутировал массив";
    }

    public static void changeAllToTen(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}