Представите, что  Вы пишите банковское приложение. 
# 1.
а. Создайте класс MyDate со следующими атрибутами (int day, int month, int year). Напишите метод конструктор и toString
    .
b. Создайте класс Person со следующими атрибутами 
    String firstName, 
    String lastName, 
    MyDate birtday
    Напишите методы конструктор, toString.
    
с. Создайте класс Account со следующими атрибутами:
 	String IBAN   (номер счета), 
    Person owner (владелец), 
    double balance (баланс),
    MyDate dayOpen (дата открытия)
    Напишите метод конструктор, toString.

Создайте несколько счетов, создайте массив из счетов, распечатайте список счетов.

# 2
В классе Account  напишите метод incomeTransaction(double amount)  , который увеличивает баланс счета на сумму amount.   
В nested.example01.Main напишите метод, который используя метод incomeTransaction,  добавляет ко всем счетам из массива 1000. 