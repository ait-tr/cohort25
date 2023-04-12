public class H2023_04_12_t1 {
    public static void main(String[] args) {
        // Написать метод, который возвращает ИНДЕКС максимального элемента в массиве
        int[] array1 = new int[]{169, 10, 9, 8, 1, 12};
        System.out.println(getIndexOfMax(array1));
        int[] array2 = getSwappedMinMaxClone(array1);
        print(array2);
        print(array1);
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] getSwappedMinMaxClone(int[] arr) {
        // создали новый массив такой же длины со значениями по умолчанию
        int[] newArr = new int[arr.length];
        // теперь нужно заполнить массив, то есть скопировать значения из старого
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        int indexOfMin = getIndexOfMin(newArr);
        int indexOfMax = getIndexOfMax(newArr);
        int temp = newArr[indexOfMin];
        newArr[indexOfMin] = newArr[indexOfMax];
        newArr[indexOfMax] = temp;
        return newArr;
    }

    public static int getIndexOfMin(int[] arr) {
        int minValue = arr[0];
        int indexOfMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    public static int getIndexOfMax(int[] arr) {
        int maxValue = arr[0];
        int indexOfMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    public static int getIndexOfMaxVer2(int[] arr) {
        int indexOfMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[indexOfMax] < arr[i]) {
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }


}
