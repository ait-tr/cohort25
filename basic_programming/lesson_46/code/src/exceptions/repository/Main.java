package repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WordsRepository wordsRepository = new WordsRepository("input2.txt");
        WordTransformer wordTransformer = new WordTransformer(wordsRepository);

        String word = wordTransformer.getUpperCaseWord();
        System.out.println(word); // HELLO
    }
}
