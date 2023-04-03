public class H2023_04_03_t2 {
    public static void main(String[] args) {
        // Выведите в консоль такую последовательность чисел 1 2 4 8 16 32 64 128 256 512.
        int i = 1;
        while (i <= 512) {
            System.out.println(i);
            i *= 2;
        }
        int j = 0;
        while(j <=9){
            // возведение 2 в степень j
            System.out.println((int) Math.pow(2, j));
            j++;
        }


    }


}
