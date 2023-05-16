public class MyDate implements Comparable<MyDate>{
    private int day;
    private int month;
    private  int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /*
     реализация метода compareTo
     если годы не равны, сравниваем годы, иначе
     если месяцы не равны, сравниваем месяцы, иначе
     сравниваем дни
     */


    @Override
    public int compareTo(MyDate o) {
        if (this.year!=o.year) {
            return this.year - o.year;
        } else if (this.month!=o.month){
            return this.month - o.month;
        } else {
            return this.day - o.day;
        }
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
