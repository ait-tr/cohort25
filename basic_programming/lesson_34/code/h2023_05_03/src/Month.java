public enum Month {
  JANUARY("Январь", 1),
  FEBRUARY("Февраль", 2),
  MARCH("Март", 3),
  APRIL("Апрель", 4),
  MAY("Май", 5),
  JUNE("Июнь", 6),
  JULY("Июль", 7),
  AUGUST("Август", 8),
  SEPTEMBER("Сентябрь", 9),
  OCTOBER("Октябрь", 10),
  NOVEMBER("Ноябрь", 11),
  DECEMBER("Декабрь", 12);
  final String monthNameRu;
  final int number;
  public int getNumber(){
    return number;
  }
  public String getName(){
    return monthNameRu;
  }
  Month(String monthNameRu, int number) {
    this.monthNameRu = monthNameRu;
    this.number = number;
  }
}
