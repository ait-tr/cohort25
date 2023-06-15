package example01;

public class Dictionary {

    private static class WordsPair {
        private String word;
        private String wordTransl;

        public WordsPair(String word, String wordTransl) {
            this.word = word;
            this.wordTransl = wordTransl;
        }
    }

    public class Translator {

        public String[] text;

        public String[] translate(String[] text) {
            String[] wordsTransl = new String[text.length];

            for (int i = 0; i < text.length; i++) {
                for (int j = i; j < text.length; j++)
                    if (pairs[j].word.equals(text[i])) {
                        wordsTransl[count] = pairs[i].wordTransl;
                        count++;
                        System.out.println(" " + wordsTransl[i]);
                    }
            }
            return null;
        }
    }

    private WordsPair[] pairs;
    private int count;

    public Dictionary() {
        this.pairs = new WordsPair[10];
        this.count = 0;
    }

    public void put(String word, String wordTransl) {
        for (int i = 0; i < count; i++) {
            if (pairs[i].word.equals(word)) {
                pairs[i].wordTransl = wordTransl;
                return;
            }
        }
        WordsPair wordsPair = new WordsPair(word, wordTransl);
        this.pairs[count] = wordsPair;
        count++;
    }

    public String get(String word) {
        for (int i = 0; i < count; i++) {
            if (pairs[i].word.equals(word)) {
                return pairs[i].wordTransl;
            }
        }
        return ("-1");
    }
}