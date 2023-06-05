public class Calculator {
  int process(Operationable operation, int a, int b){
    return operation.calculate(a,b);
  }
}
