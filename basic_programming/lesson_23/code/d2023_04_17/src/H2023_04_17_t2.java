public class H2023_04_17_t2 {
    public static void main(String[] args) {
//        Создайте метод, который принимает массив и число -
//        возвращает элемент массива по этому числу (номеру).
//        Пусть метод выбрасывает ошибку, если число меньше нуля
//        или больше длины массива - 1.
//        Добавьте сообщение в ошибку, вызовите метод в main.
        int[] numbers = {9, 12, 14};
        try {
            int x = getElementByIndex(numbers, 5);
            System.out.println(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static int getElementByIndex(int[] arr, int index) throws Exception {
        if (index < 0 || index > arr.length - 1) {
            // здесь будем выбрасывать исключение
            throw new Exception("Index " + index + " не входит в пределы массива");
        } else {
            return arr[index];
        }
    }

}
