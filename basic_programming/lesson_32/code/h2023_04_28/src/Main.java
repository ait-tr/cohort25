import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // "101" -> 5
        // "100" ->  1*2^2 + 0*2^1 + 0*2^0 -> 4
        char one = '1';
        int oneInt = (int)one - 48; // разница между номером символа и числом будет равна 48
        System.out.println(oneInt);
        System.out.println("*****");
        System.out.println(fromBinaryToDec("100"));
        System.out.println(fromBinaryToDec("1000"));
    }
    public static int fromBinaryToDec(String binary){
        int acc = 0;
        for(int i = 0; i < binary.length(); i++){
            // (цифра по индексу) * 2 ^ разряд
            // i - отвечает за степень
            // binary.length()-1-i - индекс цифры
            // binary.charAt(binary.length()-1-i); - получили символ цифры, например'0'
            // convert(binary.charAt(binary.length()-1-i)); -> цифра как интеджер
//            System.out.println(convert(binary.charAt(binary.length()-1-i)));
//            System.out.println(
//                    convert(binary.charAt(binary.length()-1-i)) * (int)Math.pow(2, i)
//            );
            acc += convert(binary.charAt(binary.length()-1-i)) * (int)Math.pow(2, i);
        }
        return acc;
        // System IO // BufferedWriter
    }
    public static int convert(char symbol){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        return map.get(symbol);
    }
}