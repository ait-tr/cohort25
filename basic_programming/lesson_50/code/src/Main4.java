import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // у нас есть отсортированный массив
        int[] a = {-100, -1, 3, 10, 11, 13, 15, 34, 45};
        boolean contains = false; // содержится
        int indexOfNumber = -1; // индекс найденного числа
        // считываем число, которое будем искать
        int number = scanner.nextInt();
        // определяем границы, где будем искать число
        // сначала это весь массив
        int left = 0;
        int right = a.length - 1;
        // вычисляем индекс середины
        int middle = left + (right - left) / 2;
        // мы постоянно повторяем одно и то же действие
        // пока left не перейдет за right
        // это случается, когда числа нет
        while (left <= right) {
            // сравниваем число, которое мы ищем
            // с центральным элементом a[middle]
            if (number < a[middle]) { // если число меньше центра - то двигаем правую границу
                right = middle - 1;
            } else if (number > a[middle]) { // если число больше центра - то двигаем левую границу
                left = middle + 1;
            } else {
                // а если вдруг попали в центр - то значит число нашли
                contains = true;
                indexOfNumber = middle;
                break;
            }
            // если мы так и не нашли число, значит у нас изменились границы и
            // следовательно, у нас будет новый центр
            middle = left + (right - left) / 2;
        }

        if (contains) {
            System.out.println(indexOfNumber);
        } else {
            System.out.println("Не найдено");
        }

    }
}
