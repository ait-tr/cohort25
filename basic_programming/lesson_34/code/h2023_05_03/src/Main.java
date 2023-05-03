public class Main {
  public static void main(String[] args) {
    System.out.println(getSeasonByMonth(Month.JULY));
    System.out.println(Month.JULY.monthNameRu);
    System.out.println(Month.JULY.number);      // здесь точка имя поля
    System.out.println(Month.JULY.getNumber()); // здесь точка имя метода
    printAllMonth();
  }
  public static void printAllMonth(){
    for(Month month: Month.values()){
      System.out.println("Месяц " + month.getNumber() + " - " +  month.getName());
    }
  }
  public static Season getSeasonByMonth(Month month){
    return switch (month) {
      case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
      case MARCH, APRIL, MAY -> Season.SPRING;
      case JUNE, JULY, AUGUST -> Season.SUMMER;
      default -> Season.AUTUMN;
    };
  }
}

// git - система контроля версий
// git - работает с репозиториями - это таки папки - в которых хранится история изменений