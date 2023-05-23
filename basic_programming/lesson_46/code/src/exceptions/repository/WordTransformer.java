package repository;

import java.io.IOException;

// преобразователь слов
public class WordTransformer {

    private WordsRepository wordsRepository; // репозиторий слов

    public WordTransformer(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    public String getUpperCaseWord() {
        String word = wordsRepository.readWord(); // читаем слово из файла
        return word.toUpperCase(); // вернули это слово большими буквами
    }

}
