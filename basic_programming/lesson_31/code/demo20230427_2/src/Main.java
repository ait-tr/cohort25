import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String strNum = "3456";
        //
        //    3*10^3      +     4*10^2     +     5*10^1     +  6* 10^0
        System.out.println(parseInt(strNum));
    }
    public static  int parseInt(String strNum){
        //"3456"
        int row = 1; // текущий коэфициент умножения т.е. 10 в какой-то степени
        int sum = 0;
        for (int i = strNum.length()-1; i >=0 ; i--) {
            int chNum = charNumToInt(strNum.charAt(i));
            int num = chNum*row;
            sum=sum + num;
            System.out.println(chNum +"*" + row + " = " + chNum*row);
            row=row*10; // получаем очередную степень десятки
        }

      return sum;
    }

    public static  int charNumToInt(char ch){  // '0' '1' .....'9'
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        return map.get(ch);
    }
}