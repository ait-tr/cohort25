public class Dictionary {

  private DictionaryPair[] pairs;
  private int count;

  public Dictionary() {
    this.pairs = new DictionaryPair[10];
    this.count = 0;
  }

  public void put(String key, String value) {
    pairs[count]  = new DictionaryPair(key, value);
    count++;
  }

  public String get(String key) {
    for(int i = 0; i < count; i++ ){
      if(pairs[i].word.equals(key)){
        return pairs[i].translation;
      }
    }
    return null;
//    throw new IllegalArgumentException("Слова "+ key + " нет в словаре");
  }

  private static class DictionaryPair {
    final String word;
    final String translation;

    public DictionaryPair(String word, String translation) {
      this.word = word;
      this.translation = translation;
    }
  }
  public class Translator{
    public String[] translate(String[] words){
      String[] translations = new String[words.length];
      for (int i = 0; i < words.length; i++){
        translations[i] = get(words[i]);
      }
      return translations;
    }
  }
}
