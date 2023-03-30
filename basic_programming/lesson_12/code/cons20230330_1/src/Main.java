public class Main {
    public static void main(String[] args) {
        System.out.println("getDayOfWeek(1) : "+getDayOfWeek(1)); // понедельник
        System.out.println("getDayOfWeek(7) : "+getDayOfWeek(7)); // воскресенье
        System.out.println("getDayOfWeek(2) : "+getDayOfWeek(2)); // вторник
        System.out.println("getDayOfWeek(0) : "+getDayOfWeek(0)); // error
        System.out.println("getDayOfWeek(10) : "+getDayOfWeek(10)); // error
        qwe("qw");
        return;
    }

    public static void qwe(String str){
        if(str.length()>3){
            System.out.println("строка длинна");
            return;  // прерывает работу метода
        } else {
            System.out.println(str);
        }
        System.out.println("метод продолжает работы");
        System.out.println("дошел до конца");
    }

    public static String getDayOfWeek(int dayNum){
       if (dayNum>7 || dayNum<1) {
           return "error";
       }

       switch (dayNum){
           case 1: return "понедельник";
           case 2: return "вторник";
           case 3: return "среда";
           case 6: return "суббота";
           case 4: return "четверг";
           case 7: return "воскресенье";
           case 5: return "пятница";
       }
        return "";
    }

    public static String getDayOfWeek2(int dayNum){
        if (dayNum>=1 && dayNum<=7) {
            switch (dayNum) {
                case 1:
                    return "понедельник";
                case 2:
                    return "вторник";
                case 3:
                    return "среда";
                case 6:
                    return "суббота";
                case 4:
                    return "четверг";
                case 7:
                    return "воскресенье";
                case 5:
                    return "пятница";
            }
        }
        return "error";
    }



}