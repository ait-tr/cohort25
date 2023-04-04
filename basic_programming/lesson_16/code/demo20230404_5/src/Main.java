public class Main {
    /*
    проверить корректность даты. Дано три числа, проверить могут ли они
    составлять корректную дату
     */
    public static void main(String[] args) {
        int day=30;
        int month=4;
        int year=2001;
        //------------------------------
        System.out.println(checkDate(day,month,year));
    }
    public static boolean checkDate(int day, int month, int year){
        return isYearCorrect(year) && isMonthCorrect(month) && isDayCorrect(day, month, year);
    }

    public static boolean isYearCorrect(int year){
        return year>0;
    }

    public static boolean isMonthCorrect(int month){
        return month>=1 && month<=12;
    }

    public static  boolean isDayCorrect(int day, int month, int year){
        return day>=1 && day<=countDayPerMonth(month, year);
    }

    public static int countDayPerMonth(int month, int year){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
        };
        return (isLeap(year)?29:28);
    }

    public static boolean isLeap(int year){
        return year%4==0;
    }

}
