import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
//    Создать класс "Dictionary" - таблица слов и их переводов.
//
//    dictionary.put("Hello", "Привет");
//    dictionary.put("Bye", "Пока");
//    dictionary.get("Hello"); // Привет
//
//    Вложенный класс - DictionaryPair (содержит исходное слово и перевод)
//    Внутренний класс - Translator
//
//    Класс содержит метод String[] translate(String[] words)
//
//    dictionary.put("Hello", "Привет");
//    dictionary.put("Bye", "Пока");
//
//    String[] words = {"Hello", "Bye", "Java"};
//
//    translator.translate(words); // {"Привет", "Пока", "Java"}
//
//    Он переводит входной набор слов по конкретному словарю.
    Dictionary dictionary = new Dictionary();
    dictionary.put("assertion", "утверждение");
    dictionary.put("prove", "доказывать");
    dictionary.put("main", "главный");
    System.out.println(dictionary.get("prove"));
    try {
      System.out.println(dictionary.get("compile"));
    } catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    System.out.println(dictionary.get("main"));
    dictionary.put("hello", "привет");
    dictionary.put("cat", "кошка");
    dictionary.put("dog", "собака");

    Dictionary.Translator translator = dictionary.new Translator();
    String[] words = new String[]{"assertion", "prove", "main", "hello", "cat", "dog"};
    String[] translations1 =  translator.translate(words);
    System.out.println(Arrays.toString(translations1));

    Dictionary bidloSlovar = new Dictionary();
    bidloSlovar.put("assertion", "отвечаю");
    bidloSlovar.put("prove", "зуб даю");
    bidloSlovar.put("main", "батя");
    bidloSlovar.put("hello", "чёкаво");
    bidloSlovar.put("cat", "мурка");
    bidloSlovar.put("dog", "псина");
    Dictionary.Translator bidloTranslator = bidloSlovar.new Translator();

    String[] translations2 =  bidloTranslator.translate(words);
    System.out.println(Arrays.toString(translations2));

    String[] words3 = new String[]{"assertion", "cort", "main", "late", "shark", "dog"};
    String[] translations3 = translator.translate(words3);
    System.out.println(Arrays.toString(translations3));

  }
}