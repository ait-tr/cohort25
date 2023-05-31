import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] a = {45, 10, -1, 34, 15, -100, 13, 3};

        int currentMin;
        int indexOfCurrentMin;
        int temp;

        currentMin = a[0]; // текущий минимальный -> 45
        indexOfCurrentMin = 0; // индекс текущего минимального -> 0

        for (int j = 1; j < a.length; j++) {
            if (a[j] < currentMin) { // если a[j] меньше, чем текущий минимальный
                currentMin = a[j]; // запоминаем его как минимальный
                indexOfCurrentMin = j; // запомнили его индекс
            }
        }

        // a[0] <-> a[indexOfCurrentMin]
        temp = a[0];
        a[0] = a[indexOfCurrentMin];
        a[indexOfCurrentMin] = temp;

        System.out.println(Arrays.toString(a));

        currentMin = a[1]; // текущий минимальный -> 10
        indexOfCurrentMin = 1; // индекс текущего минимального -> 1

        for (int j = 2; j < a.length; j++) {
            if (a[j] < currentMin) { // если a[j] меньше, чем текущий минимальный
                currentMin = a[j]; // запоминаем его как минимальный
                indexOfCurrentMin = j; // запомнили его индекс
            }
        }

        // a[0] <-> a[indexOfCurrentMin]
        temp = a[1];
        a[1] = a[indexOfCurrentMin];
        a[indexOfCurrentMin] = temp;

        System.out.println(Arrays.toString(a));

        currentMin = a[2]; //
        indexOfCurrentMin = 2; //

        for (int j = 3; j < a.length; j++) {
            if (a[j] < currentMin) { // если a[j] меньше, чем текущий минимальный
                currentMin = a[j]; // запоминаем его как минимальный
                indexOfCurrentMin = j; // запомнили его индекс
            }
        }

        // a[0] <-> a[indexOfCurrentMin]
        temp = a[2];
        a[2] = a[indexOfCurrentMin];
        a[indexOfCurrentMin] = temp;

        System.out.println(Arrays.toString(a));

        currentMin = a[3]; //
        indexOfCurrentMin = 3; //

        for (int j = 4; j < a.length; j++) {
            if (a[j] < currentMin) { // если a[j] меньше, чем текущий минимальный
                currentMin = a[j]; // запоминаем его как минимальный
                indexOfCurrentMin = j; // запомнили его индекс
            }
        }

        // a[0] <-> a[indexOfCurrentMin]
        temp = a[3];
        a[3] = a[indexOfCurrentMin];
        a[indexOfCurrentMin] = temp;

        System.out.println(Arrays.toString(a));
    }
}
