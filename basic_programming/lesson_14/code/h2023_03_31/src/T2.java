public class T2 {
    public static void main(String[] args) {
        // ### Задача 3
        // Напишите метод, который получает две строки и возвращает длинну строки (т.е. int), которая длиннее.
        System.out.println(lengthOfLongest("Rooster", "Mice"));
    }
    public static int lengthOfLongest(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        return length1 > length2 ? length1: length2;
        // return Math.max(str1.length(), str2.length());  // другой вариант решения
    }
}
