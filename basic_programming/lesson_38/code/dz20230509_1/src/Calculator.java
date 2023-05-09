public class Calculator {

    public static double add(double num1, double num2){
        return num1+num2;
    }
    public static double sub(double num1, double num2){
        return num1-num2;
    }
    public static double mul(double num1, double num2){
        return num1*num2;
    }

    /*
    public static double div(int num1, int num2){
        try {
            return num1*1.0 / num2;
        } catch (Exception e){
            System.out.println("Log: ошибочный параметр " + num2);
            return 0;
        }
    }
    */
    public static double div(int num1, int num2){
        return num1/num2;
    }
}

