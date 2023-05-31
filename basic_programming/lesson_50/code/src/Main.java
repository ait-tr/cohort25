import java.util.Arrays;
import java.util.Random;

public class Main {

    public static boolean linearSearch(int[] array, int element) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            counter++;
            // пробегаем весь массив
            if (array[i] == element) { // если какой-то элемент массива совпал с искомым
                return true; // возвращаем результат true (останавливая метод)
            }
        }
        System.out.println("В linearSearch было сделано " + counter + " сравнений");
        return false; // если не нашли ни одного элемента - возвращаем false
    }

    public static void selectionSort(int[] array) {
        int counter = 0;
        int currentMin;
        int indexOfCurrentMin;
        int temp;

        for (int i = 0; i < array.length; i++) {
            currentMin = array[i];
            indexOfCurrentMin = i;

            for (int j = i + 1; j < array.length; j++) { // поиск минимального
                counter++;
                if (array[j] < currentMin) { // если a[j] меньше, чем текущий минимальный
                    currentMin = array[j]; // запоминаем его как минимальный
                    indexOfCurrentMin = j; // запомнили его индекс
                }
            }

            // a[0] <-> a[indexOfCurrentMin]
            temp = array[i];
            array[i] = array[indexOfCurrentMin];
            array[indexOfCurrentMin] = temp;
        }
        System.out.println("В selectionSort было сделано " + counter + " сравнений");
    }

    public static boolean binarySearch(int[] array, int element) {
        int counter = 0;
        boolean contains = false;
        int left = 0;
        int right = array.length - 1;
        // вычисляем индекс середины
        int middle = left + (right - left) / 2;
        // мы постоянно повторяем одно и то же действие
        // пока left не перейдет за right
        // это случается, когда числа нет
        while (left <= right) {
            // сравниваем число, которое мы ищем
            // с центральным элементом a[middle]
            counter++;
            if (element < array[middle]) { // если число меньше центра - то двигаем правую границу
                right = middle - 1;
            } else if (element > array[middle]) { // если число больше центра - то двигаем левую границу
                left = middle + 1;
            } else {
                // а если вдруг попали в центр - то значит число нашли
                contains = true;
                break;
            }
            // если мы так и не нашли число, значит у нас изменились границы и
            // следовательно, у нас будет новый центр
            middle = left + (right - left) / 2;
        }
        System.out.println("В binarySearch было сделано " + counter + " сравнений");
        return contains;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = {45, 10, -1, 34, 15, -100, 13, 3};

        int[] generated = new int[1000_000];

        for (int i = 0; i < generated.length; i++) {
            generated[i] = random.nextInt(1000);
        }
        System.out.println(linearSearch(generated, 1500));
//        selectionSort(generated);
        Arrays.sort(generated);
        System.out.println(binarySearch(generated, 1500));
//        selectionSort(a);
//        System.out.println(binarySearch(a, 1000));


    }
}
