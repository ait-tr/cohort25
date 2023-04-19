public class MyDate {
    int day;
    int month;
    int year;
    MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String toString(){
        return day + "-" + month + "-" + year;
    }
}
