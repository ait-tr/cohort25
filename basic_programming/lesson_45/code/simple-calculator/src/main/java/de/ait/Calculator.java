package de.ait;

public class Calculator {
  public static double sum(double x, double y){
    return x + y;
  }
  public static double pow(double x, int power){
//    return 4; // два теста не проходил
    return Math.pow(x, power);
  }
}
